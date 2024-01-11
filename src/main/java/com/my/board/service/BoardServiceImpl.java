package com.my.board.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.my.board.dao.BoardRepository;
import com.my.board.dto.BoardDTO;
import com.my.board.entity.BoardEntity;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper model;
	
	@Autowired
	BoardRepository repository;


	@Override
	public void createBoard(BoardDTO dto) throws AddException {

		// dto 객체로 들어온 것을 entiiy로 변환
		BoardEntity entity = model.DtoToVo(dto);
		
		BoardEntity savedEntity = repository.save(entity);

	} // createBoard

	@Override
	public Page<BoardDTO> findAll(Pageable pageable) throws FindException {
		
		Page<BoardEntity> entity = repository.findAll(pageable);

		return entity.map(model::VoToDTO);
	
	} // findAll

	@Override
	public void modifyBoard(BoardDTO dto) throws ModifyException {
		
	    Long receiveId = dto.getId();
	    Optional<BoardEntity> optionalBoard = repository.findById(receiveId);

	    if (optionalBoard.isPresent()) {
	        BoardEntity existingEntity = optionalBoard.get();
	        if (receiveId.equals(existingEntity.getId())) {

	            if (dto.getTitle() != null) {
	                existingEntity.setTitle(dto.getTitle());
	            }
	            if (dto.getContent() != null) {
	                existingEntity.setContent(dto.getContent());
	            }
	            if (dto.getMemberId() != null) {
	                existingEntity.setMemberId(dto.getMemberId());
	            }
	            
	            repository.save(existingEntity);
	        } else {
	            throw new ModifyException("게시글 번호가 일치하지 않습니다");
	        }
	    } else {
	        throw new ModifyException("해당 게시물 번호와 일치하는 게시물이 없습니다.");
	    }
	    
	} // modify

	@Override
	public void removeBoard(Long id) throws RemoveException {

		Optional<BoardEntity> optionalBoard = repository.findById(id);

		if (optionalBoard.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RemoveException("해당 게시물이 존재하지 않습니다.");
		} // if-else

	} // remove
	
	
} // end class

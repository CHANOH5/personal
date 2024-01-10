package com.my.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.board.dao.BoardRepository;
import com.my.board.dto.BoardDTO;
import com.my.board.entity.BoardEntity;
import com.my.exception.AddException;

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

} // end class

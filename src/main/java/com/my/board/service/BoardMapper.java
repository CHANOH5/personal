package com.my.board.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.my.board.dao.BoardRepository;
import com.my.board.dto.BoardDTO;
import com.my.board.entity.BoardEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardMapper {
	
	private BoardRepository repository;
	
	private ModelMapper mapper;
	
	public BoardMapper() {
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration()
				   .setMatchingStrategy(MatchingStrategies.STANDARD)
				   .setFieldAccessLevel(AccessLevel.PRIVATE)
				   .setFieldMatchingEnabled(true);
	}
	
	// DTO -> VO
	public BoardEntity DtoToVo(BoardDTO dto) {

		log.warn("3. DtoToVo의 att =====> {}", dto);
		
		Object source = dto;

		Class<BoardEntity> destinationType = BoardEntity.class;
		
		BoardEntity entity = mapper.map(source, destinationType);

		return entity;

	} // DtoToVo
	
	public BoardDTO VoToDTO(BoardEntity entity) {

		ModelMapper mapper = new ModelMapper();
		
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setFieldAccessLevel(AccessLevel.PRIVATE)
				.setFieldMatchingEnabled(true);
		
		Object source = entity;
		
		Class<BoardDTO> destinationType = BoardDTO.class;
		
		BoardDTO dto = mapper.map(source, destinationType);
		
		return dto;
		
	} // VoToDTO

}

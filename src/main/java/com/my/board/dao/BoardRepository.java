package com.my.board.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

	Optional<BoardEntity> findById(Optional<BoardEntity> boardId);

	
//	public Page<BoardEntity> findAllById(Pageable pageable) throws FindException;
	
	
} // end class	

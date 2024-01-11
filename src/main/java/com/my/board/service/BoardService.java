package com.my.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.my.board.dto.BoardDTO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

public interface BoardService {

	// 게시글 등록
	public void createBoard(BoardDTO dto) throws AddException;
	
	// 게시글 목록 조회
	public Page<BoardDTO> findAll(Pageable pageable) throws FindException;
	
	// 게시글 수정
	public void modifyBoard(BoardDTO dto) throws ModifyException;
	
	// 게시글 삭제
	public void removeBoard(Long id) throws RemoveException; 
	
} // end class

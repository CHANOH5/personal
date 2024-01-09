package com.my.board.service;

import com.my.board.dto.BoardDTO;
import com.my.exception.AddException;

public interface BoardService {

	// 게시글 등록
	public void createBoard(BoardDTO dto) throws AddException;
	
} // end class

package com.my.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.board.dto.BoardDTO;
import com.my.board.service.BoardServiceImpl;
import com.my.exception.AddException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/board")
@CrossOrigin()
public class BoardController {
	
	@Autowired
	private BoardServiceImpl service;
	
	@PostMapping()
	public ResponseEntity<?> createBoard(@RequestBody BoardDTO dto) throws AddException {
		
		try {
			service.createBoard(dto);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (AddException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		} // try - catch
		
	} // createBoard
	
} // end class

package com.my.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.board.dto.BoardDTO;
import com.my.board.service.BoardServiceImpl;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

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
	
	@GetMapping("/list")
	public Page<BoardDTO> findAll(@PageableDefault(size=10) Pageable pageable) throws FindException {
		
		return service.findAll(pageable);
		
	} // findAll
	
	@PutMapping()
	public ResponseEntity<?> modifyBoard(@RequestBody BoardDTO dto) throws ModifyException {
		
		try {
			
			service.modifyBoard(dto);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (ModifyException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} // try-catch
 			
	} // modify
	
	@DeleteMapping(value= "{id}")
	public ResponseEntity<?> removeBoard(@PathVariable Long id) throws RemoveException {
		try {
			
			service.removeBoard(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (RemoveException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} // try-catch
		
	} // remove
	
} // end class

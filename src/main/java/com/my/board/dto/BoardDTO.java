package com.my.board.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class BoardDTO {

	private Long id;
	
	private String title;
	
	private String content;
	
	private String memberId;

	@JsonFormat(pattern="yy/MM/dd", timezone="Asia/Seoul")
	private Date regDate;

} // end class

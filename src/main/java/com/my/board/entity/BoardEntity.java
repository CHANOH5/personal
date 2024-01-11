package com.my.board.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

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

@Entity
@Table(name="board")
@DynamicInsert
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR",
		sequenceName = "board_seq",
		initialValue = 1,
		allocationSize = 1
		)
public class BoardEntity {

	@Id
	@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "BOARD_SEQ_GENERATOR"
			)
	private Long id; // 게시글 번호
	
	@Column
	private String title;	// 게시글 제목
	
	@Column
	private String content;		// 게시글 내용
	
	@Column
	private String memberId;	// 작성자
	
	@Column
	private Date regDate;	// 작성일
	
} // end class

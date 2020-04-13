package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Comment { //후기댓글
	
	private int commentNum;		//후기 댓글 번호
	private String userId;		//후기 작성자 아이디
	private int reviewNum;		//후기 번호
	private int commentIndex; 	//답글 순서
	private String commentContent;	//후기 내용
	private Date commentDate;		//후기 작성날짜

	
	
}

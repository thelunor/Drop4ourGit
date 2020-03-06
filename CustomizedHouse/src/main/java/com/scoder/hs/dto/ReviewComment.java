package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class ReviewComment { //후기댓글
	private int comNum;		//후기 댓글 번호
	private String comContent;	//후기 내용
	private Date comDate;		//후기 작성날짜
	private int reviewNum;		//후기 번호
	private String userId;			//후기 작성자 아이디
	private String reaId;			//중개사 아이디

	
}

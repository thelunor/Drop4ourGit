package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Review { //후기
	
	private int reviewNum;			//후기 번호
	private String userId;			//후기 작성자 아이디
	private String reviewContent;	//후기 내용
	private String reviewDate;		//후기 작성 시간
	private String reaId;			//공인중개사 아이디
	
}


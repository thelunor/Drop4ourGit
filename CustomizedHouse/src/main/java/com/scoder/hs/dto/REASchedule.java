package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REASchedule { //공인중개사 매물 일정 관리
	
	private int scheNum; //일정번호
	private Date scheDate; //일정 날짜
	private String content; //내용
	private String reaId; //공인중개사 아이디
	
}

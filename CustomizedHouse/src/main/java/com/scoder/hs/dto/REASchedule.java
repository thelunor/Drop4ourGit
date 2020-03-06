package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REASchedule { //공인중개사 매물 일정 관리
	
	private int scheduleNum; //일정번호
	private Date scheduleDate; //일정 날짜
	private String scheduleContent; //내용
	private String userId; //공인중개사 아이디
	
}

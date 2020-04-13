package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class BookMark { //매물 북마크
	
	private String userId; //아이디 
	private String saleNum; //매물번호
	private Date bookDate; //북마크 등록 날짜

}

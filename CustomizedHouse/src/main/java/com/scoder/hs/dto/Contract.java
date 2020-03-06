package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Contract {	//계약서
	
	private String saleNum;	//매물번호
	private String contractNum; //거래유형번호
	private String constractType; //거래유형명
	
	private Date contractDate;		//계약날짜
	private String conPrice;	//계약금
	private String midPrice;	//중도금
	private String balance;	//잔금
	
}

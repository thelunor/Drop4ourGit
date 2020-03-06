 package com.scoder.hs.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REAUser {//중개사
	
	private String reaId; 
	private String reaPwd;
	private String reaName;
	private String reaPhoneNum;
	private String officeName;//사무실 이름
	private String officeAddr;	//사무실 주소
	private String officeDetailAddr; //사무실 상세주소
	private String officeHp; //사무실 번호
	private String regNum; //사업자 등록번호
	private String userCode;

}

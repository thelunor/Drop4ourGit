 package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REAUser {//중개사
	
	private String userId; 
	private String reaNum; 		//사업자 등록번호
	private String officeName;	//사무실 이름
	private String officeAddress;	//사무실 주소
	private String officeDetailAddress; //사무실 상세주소
	private String officePhoneNum; //사무실 번호

}

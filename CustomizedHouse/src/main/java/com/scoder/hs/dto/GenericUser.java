package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class GenericUser{	//일반회원
	
	private String userId; 
	private String userPwd;
	private String userName;
	private String frontResNum; //주민등록번호 앞자리
	private String backResNum; //주민등록번호 뒷자리
	private String userPhoneNum;
	private String userAddr; //주소
	private String userDetailAddr; //상세주소
	private String userCode; //회원 코드 
	
}

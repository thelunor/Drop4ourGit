package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class GenericUser{ //일반회원
	
	private String userId; 
	private String resNum; //주민등록번호
	private String userAddress; //주소
	private String userDetailAddress; //상세주소

}

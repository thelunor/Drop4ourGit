package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class OfficeImage { //사무실 이미지
	
	private String userId; //공인중개사 아이디
	private String officeImageName; //사무실 이미지명

}

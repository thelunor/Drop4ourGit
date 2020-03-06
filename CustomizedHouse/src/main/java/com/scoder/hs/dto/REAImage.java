package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REAImage {	//중개사 이미지
	
	private String reaId;				//중개사 아이디
	private String reaImgOriginName;	//중개사 이미지 원본 파일명
	private String reaImgSaveName;		//중개사 이미지 저장 파일명
	
	
}

package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class SaleImage { //매물이미지
	private String saleImgOriginName1; //매물사진 원본 파일명1
	private String saleImgSaveName1; //매물사진 저장 파일명1
	private String saleImgOriginName2; //매물사진 원본 파일명2
	private String saleImgSaveName2; //매물사진 저장 파일명2
	private String saleImgOriginName3; //매물사진 원본 파일명3
	private String saleImgSaveName3; //매물사진 저장 파일명3

	private String aptNum; //매물번호
	
}

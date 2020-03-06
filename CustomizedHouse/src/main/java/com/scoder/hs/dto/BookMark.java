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
	private String aptNum; //매물번호
	private Date bookDate; //북마크 등록 날짜
	private String aptSize; //면적
	private String type; //거래유형
	private String aptName; //아파트 이름
	private String price; //거래금액
	private String saleImgSaveName1; //아파트 사진
}

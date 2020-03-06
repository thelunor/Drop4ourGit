package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class SaleImage { //매물이미지
	private int saleImageNum; //매물 이미지 번호
	private int saleNum; //매물번호
	private String saleImageName; //매물 이미지명
	
}

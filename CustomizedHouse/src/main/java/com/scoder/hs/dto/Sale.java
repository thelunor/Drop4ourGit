package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Sale { //매물
	
	private int saleNum; //매물번호
	private String userId; //공인중개사 아이디
	private String typeNum; //거래유형번호
	private String aptSize; //면적
	private String address; //지번주소
	private String roadAddress; //도로명주소
	private String aptName; //아파트 이름
	private String aptDong; //동
	private String aptHo; //호	
	private String price; //거래금액
	private String direction; //향
	private String etc; //매물 특징
	private String isContract; //계약 여부

}

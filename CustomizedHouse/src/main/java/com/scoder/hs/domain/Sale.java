package com.scoder.hs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saleNum; //매물번호	
	
	@Column(name="userid", updatable=false, nullable=false)
	private String userId; //공인중개사 아이디
	
	@Column(updatable=true, nullable = false)
	private int typeNum; //거래유형번호
	
	@Column(length = 100, nullable = false)
	private String aptSize; //면적
	
	@Column(columnDefinition = "SALEADDRESS", nullable = false)
	private String address; //지번주소
	
	@Column(columnDefinition = "SALEROADADDRESS", nullable = false)
	private String roadAddress; //도로명주소
	
	@Column(length = 500, nullable = false)
	private String aptName; //아파트 이름
	
	@Column(length = 500, nullable = false)
	private String aptDong; //동
	
	@Column(length = 500, nullable = false)
	private String aptHo; //호	
	
	@Column(columnDefinition = "SALEPRICE", nullable = false)
	private String price; //거래금액
	
	@Column(columnDefinition = "SALEDIRECTION", nullable = false)
	private String direction; //향
	
	@Column(columnDefinition = "SALEETC", nullable = false)
	private String etc; //매물 특징
	
	@Column(updatable=true, nullable = false)
	private String isContract; //계약 여부
	

}

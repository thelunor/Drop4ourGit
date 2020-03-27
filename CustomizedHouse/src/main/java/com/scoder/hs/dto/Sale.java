package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.SaleEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Sale { //매물
	
	private Long saleNum; //매물번호
	private int typeNum; //거래유형번호
	private String aptSize; //면적
	private String saleAddress; //지번주소
	private String saleRoadAddress; //도로명주소
	private String aptName; //아파트 이름
	private String aptDong; //동
	private String aptHo; //호	
	private String salePrice; //거래금액
	private String saleDirection; //향
	private String saleEtc; //매물 특징
	private int isContract; //계약 여부

	
	public SaleEntity toEntity() {
		SaleEntity saleEntity = SaleEntity.builder()
				.saleNum(saleNum)
				.aptSize(aptSize)
				.saleAddress(saleAddress)
				.saleRoadAddress(saleRoadAddress)
				.aptName(aptName)
				.aptDong(aptDong)
				.aptHo(aptHo)
				.salePrice(salePrice)
				.saleDirection(saleDirection)
				.saleEtc(saleEtc)
				.isContract(isContract)
				.build();
		return saleEntity;
	}

	@Builder
	public Sale(Long saleNum, String aptSize, String saleAddress, String saleRoadAddress, String aptName, String aptDong,
			String aptHo, String salePrice, String saleDirection, String saleEtc, int isContract) {
		this.saleNum = saleNum;
		this.aptSize = aptSize;
		this.saleAddress = saleAddress;
		this.saleRoadAddress = saleRoadAddress;
		this.aptName = aptName;
		this.aptDong = aptDong;
		this.aptHo = aptHo;
		this.salePrice = salePrice;
		this.saleDirection = saleDirection;
		this.saleEtc = saleEtc;
		this.isContract = isContract;
	}
	
	

}

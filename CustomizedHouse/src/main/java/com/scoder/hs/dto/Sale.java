package com.scoder.hs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class Sale { //매물
	
	private int saleNum; //매물번호
	private String userId; //공인중개사 아이디
	private int typeNum; //거래유형번호
	private String aptSize; //면적
	private String address; //지번주소
	private String roadAddress; //도로명주소
	private String aptName; //아파트 이름
	private String aptDong; //동
	private String aptHo; //호	
	private String price; //거래금액
	private String direction; //향
	private String etc; //매물 특징
	private int isContract; //계약 여부
	
	
//	public SaleEntity toEntity() {
//		SaleEntity saleEntity = SaleEntity.builder()
//				.saleNum(saleNum)
//				.userId(userId)
//				.typeNum(typeNum)
//				.aptSize(aptSize)
//				.address(address)
//				.roadAddress(roadAddress)
//				.aptName(aptName)
//				.aptDong(aptDong)
//				.aptHo(aptHo)
//				.price(price)
//				.direction(direction)
//				.etc(etc)
//				.isContract(isContract)
//				.build();
//		return saleEntity;
//	}
	
	
	@Builder
	public Sale(int saleNum, String userId, int typeNum, String aptSize, String address, String roadAddress,
			String aptName, String aptDong, String aptHo, String price, String direction, String etc,
			int isContract) {
		this.saleNum = saleNum;
		this.userId = userId;
		this.typeNum = typeNum;
		this.aptSize = aptSize;
		this.address = address;
		this.roadAddress = roadAddress;
		this.aptName = aptName;
		this.aptDong = aptDong;
		this.aptHo = aptHo;
		this.price = price;
		this.direction = direction;
		this.etc = etc;
		this.isContract = isContract;
	}
	
	

}

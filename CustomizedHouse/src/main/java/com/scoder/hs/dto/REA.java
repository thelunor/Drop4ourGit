 package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.REAEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@NoArgsConstructor
public class REA {//중개사
	
	private String userId; 
	private String reaNum; 		//사업자 등록번호
	private String officeName;	//사무실 이름
	private String officeAddress;	//사무실 주소
	private String officePhoneNum; //사무실 번호
	
	public REAEntity toEntity() {
		REAEntity reaEntity = REAEntity.builder()
				.userId(userId)
				.reaNum(reaNum)
				.officeName(officeName)
				.officeAddress(officeAddress)
				.officePhoneNum(officePhoneNum)
				.build();
		return reaEntity;
	}
	
	@Builder 
	public REA(String userId, String reaNum, String officeName, String officeAddress, String officePhoneNum) {
		this.userId = userId;
		this.reaNum = reaNum;
		this.officeName = officeName;
		this.officeAddress = officeAddress;
		this.officePhoneNum = officePhoneNum;
	}
}

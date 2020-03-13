package com.scoder.hs.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "rea")
public class REAEntity {
	
	@Id
	private String userId;
	
	@Column(length = 30, nullable = false)
	private String reaNum;
	
	@Column(length = 100, nullable = false)
	private String officeName;
	
	@Column(length = 500, nullable = false)
	private String officeAddress;
	
	@Column(length = 100, nullable = false)
	private String officePhoneNum;
	
	@Builder
	public REAEntity(String userId, String reaNum, String officeName, String officeAddress, String officePhoneNum) {
		this.userId = userId;
		this.reaNum = reaNum;
		this.officeName = officeName;
		this.officeAddress = officeAddress;
		this.officePhoneNum = officePhoneNum;
	}
	
}

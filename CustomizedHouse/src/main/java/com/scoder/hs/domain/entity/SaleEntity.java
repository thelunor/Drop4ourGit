package com.scoder.hs.domain.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sale")
public class SaleEntity {
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId", nullable = false)
	private CHUserEntity chuserEntity;
	
	@ManyToOne
	@JoinColumn(name="typeNum")
	private TypeEntity typeEntity;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "saleNum", insertable=false)
	private Long saleNum;
	
	@Column(length = 100, nullable = false)
	private String aptSize; 
	
	@Column(length = 500, nullable = false)
	private String saleAddress; 
	
	@Column(length = 500, nullable = false)
	private String saleRoadAddress;
	
	@Column(length = 500, nullable = false)
	private String aptName;
	
	@Column(length = 500, nullable = false)
	private String aptDong; 
	
	@Column(length = 500, nullable = false)
	private String aptHo;
	
	@Column(length = 500, nullable = false)
	private String salePrice;
	
	@Column(length = 500, nullable = false)
	private String saleDirection;
	
	@Column(length = 3000, nullable = false)
	private String saleEtc;
	
	@Column(length = 30, nullable = false)
	private int isContract;
	
	public String getUserId(CHUserEntity chuserEntity) {
		return chuserEntity.getUserId();
	}
	
	public void addCHUserEntity(CHUserEntity chuserEntity) {
		
	}

	@Builder
	public SaleEntity( CHUserEntity chuserEntity, Long saleNum, String aptSize,
			String saleAddress, String saleRoadAddress, String aptName, String aptDong, String aptHo, String salePrice,
			String saleDirection, String saleEtc, int isContract) {
		this.chuserEntity = chuserEntity;
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

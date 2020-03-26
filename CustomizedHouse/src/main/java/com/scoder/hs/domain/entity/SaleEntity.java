package com.scoder.hs.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

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

	@ManyToOne(targetEntity = CHUserEntity.class)
	private CHUserEntity chuserEntity;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "saleNum", insertable=false)
	private Long saleNum; //매물번호
	
	@Column(length = 100, nullable = false)
	private String aptSize; //면적
	
	@Column(length = 500, nullable = false)
	private String saleAddress; //지번주소
	
	@Column(length = 500, nullable = false)
	private String saleRoadAddress; //도로명주소
	
	@Column(length = 500, nullable = false)
	private String aptName; //아파트 이름
	
	@Column(length = 500, nullable = false)
	private String aptDong; //동
	
	@Column(length = 500, nullable = false)
	private String aptHo; //호	
	
	@Column(length = 500, nullable = false)
	private String salePrice; //거래금액
	
	@Column(length = 500, nullable = false)
	private String saleDirection; //향
	
	@Column(length = 3000, nullable = false)
	private String saleEtc; //매물 특징
	
	@Column(length = 30, nullable = false, columnDefinition = "default 1")
	private int isContract; //계약 여부
	

	@Builder
	public SaleEntity(CHUserEntity chuserEntity, Long saleNum, String aptSize, String saleAddress,
			String saleRoadAddress, String aptName, String aptDong, String aptHo, String salePrice,
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

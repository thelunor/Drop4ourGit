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
	


}

package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.REAImageEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REAImage {	//중개사 이미지
	
	private String userId;			//중개사 아이디
	private String reaImageName;	//중개사 이미지 파일명

	public REAImageEntity toEntity() {
		REAImageEntity reaImageEntity = REAImageEntity.builder()
				.userId(userId)
				.reaImageName(reaImageName)
				.build();
		return reaImageEntity;
	}

	@Builder
	public REAImage(String userId, String reaImageName) {
		this.userId = userId;
		this.reaImageName = reaImageName;
	}

}

package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Generic {
	
	private String userId;
	private String birth;
	private String resNum;
	private String userAddress;
	private String userDetailAddress;

	public GenericEntity toEntity() {
		GenericEntity genericEntity = GenericEntity.builder()
				.userId(userId)
				.birth(birth)
				.resNum(resNum)
				.userAddress(userAddress)
				.userDetailAddress(userDetailAddress)
				.build();
		return genericEntity;
	}
}

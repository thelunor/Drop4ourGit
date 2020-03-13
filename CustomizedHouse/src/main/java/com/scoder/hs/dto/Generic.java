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
	private String resNum;
	private String userAddress;

	public GenericEntity toEntity() {
		GenericEntity genericEntity = GenericEntity.builder()
				.userId(userId)
				.resNum(resNum)
				.userAddress(userAddress)
				.build();
		return genericEntity;
	}
}

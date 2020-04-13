package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@NoArgsConstructor
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

	@Builder
	public Generic(String userId, String birth, String resNum, String userAddress, String userDetailAddress) {
		this.userId = userId;
		this.birth = birth;
		this.resNum = resNum;
		this.userAddress = userAddress;
		this.userDetailAddress = userDetailAddress;
	}
	
	
}

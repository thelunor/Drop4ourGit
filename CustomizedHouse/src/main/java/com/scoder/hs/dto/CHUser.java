package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.dto.Generic.GenericBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CHUser {
	
    private String userId;
    private String password;
    private String userName;
    private String userPhoneNum;
    private int isLock;
    private int loginCnt;
    private String userEmail;
    
	public CHUserEntity toEntity() {
        CHUserEntity chUserEntity = CHUserEntity.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .userPhoneNum(userPhoneNum)
                .isLock(isLock)
                .loginCnt(loginCnt)
                .userEmail(userEmail)
                .build();
        return chUserEntity;
    }

	@Builder
	public CHUser(String userId, String userName, String userEmail, String userPhoneNum) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhoneNum = userPhoneNum;

	}
}
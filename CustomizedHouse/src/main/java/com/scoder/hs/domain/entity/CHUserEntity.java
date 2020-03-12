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
@Table(name = "chuser")
public class CHUserEntity {
	
	@Id
	private String userId;
	
	@Column(length = 500, nullable = false)
    private String password;
	
	@Column(length = 20, nullable = false)
    private String userName;
	
	@Column(length = 30, nullable = false)
    private String userPhoneNum;
	
	@Column(nullable = false)
    private int isLock;
	
	@Column(nullable = false)
    private int loginCnt;
    
    @Column(length = 30, nullable = false)
    private String userMail;

    @Builder
	public CHUserEntity(String userId, String password, String userName, String userPhoneNum, int isLock, int loginCnt,
			String userMail) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userPhoneNum = userPhoneNum;
		this.isLock = isLock;
		this.loginCnt = loginCnt;
		this.userMail = userMail;
	}

}
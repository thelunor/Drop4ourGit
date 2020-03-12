package com.scoder.hs.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CHUserCustom extends User {
	
    private String userName;
    private String userPhoneNum;
    private int isLock;
    private int loginCnt;
    private String userMail; 
	
    public CHUserCustom(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String userName, String userPhoneNum, 
			int isLock, int loginCnt, String userMail) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userName = userName;
		this.userPhoneNum = userPhoneNum;
		this.isLock = isLock;
		this.loginCnt = loginCnt;
		this.userMail = userMail;
	}
	
}

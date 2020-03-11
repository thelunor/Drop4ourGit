package com.scoder.hs.dto;

import lombok.AllArgsConstructor;
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
    private String userMail;
    
	

}
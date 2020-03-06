package com.scoder.hs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
    private String userId;
    private String userPwd;
    private String name;
    private String role;
	

}
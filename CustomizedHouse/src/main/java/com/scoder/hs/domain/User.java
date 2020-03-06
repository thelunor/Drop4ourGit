package com.scoder.hs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
	
	@Id
	@Column(name="userid", updatable=false, nullable=false)
    private String userId;
	
	@Column(name="userpwd", updatable=true, nullable=true)
    private String userPwd;
	
	@Column(name="name", updatable=true, nullable=true)
    private String name;
	
	@Column(name="role", updatable=true, nullable=true)
    private String role;
	
	public User() {}

}
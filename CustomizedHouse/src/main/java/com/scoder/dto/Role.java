package com.scoder.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="rolename", updatable=false, nullable=false)
	private String roleName;
	
	@Column(name="roledesc", updatable=false, nullable=false)
	private String roleDesc;

}

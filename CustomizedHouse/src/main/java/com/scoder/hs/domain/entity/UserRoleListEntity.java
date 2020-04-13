package com.scoder.hs.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "userRoleList")
public class UserRoleListEntity {
	
	@Id
	private String userId;
	
	@Column(name = "roleName", length = 15, nullable = false)
	private String roleName;
	
	@Builder
	public UserRoleListEntity(String userId, String roleName) {
		this.userId = userId;
		this.roleName = roleName;
	}
	
}

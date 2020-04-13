package com.scoder.hs.domain.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "role")
public class RoleEntity {
	
	@OneToMany
	@JoinColumn(name="roleName")
	private Collection<UserRoleListEntity> userRoleListEntity;
	
	@Id
	@Column (length = 20, nullable = false)
	private String roleName;
	
	@Column (length = 30, nullable = false)
	private String roleDesc;

	@Builder
	public RoleEntity(String roleName, String roleDesc) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

}

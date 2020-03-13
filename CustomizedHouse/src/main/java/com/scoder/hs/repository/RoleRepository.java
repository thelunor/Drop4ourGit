package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.hs.domain.entity.UserRoleListEntity;

@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<UserRoleListEntity, String> {
	
	Optional<UserRoleListEntity> findRoleNameByUserId(String userId);

}

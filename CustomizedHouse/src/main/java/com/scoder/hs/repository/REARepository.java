package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoder.hs.domain.entity.REAEntity;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface REARepository extends JpaRepository<REAEntity, String> {
	
	Optional<REAEntity> findByUserId(String userId);
	
}

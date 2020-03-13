package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoder.hs.domain.entity.REAEntity;

public interface REARepository extends JpaRepository<REAEntity, String> {
	
	Optional<REAEntity> findByUserId(String userId);
	
}

package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.hs.domain.entity.GenericEntity;


public interface GenericRepository extends JpaRepository<GenericEntity, String> {
	Optional<GenericEntity> findByUserId(String userId);

}

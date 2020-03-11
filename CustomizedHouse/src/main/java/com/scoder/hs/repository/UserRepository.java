package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.hs.domain.entity.CHUserEntity;


@EnableJpaRepositories
public interface UserRepository extends JpaRepository<CHUserEntity, String> {
	Optional<CHUserEntity> findById(String userId);
}

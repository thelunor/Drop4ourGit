package com.scoder.hs.repository;

import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;


@EnableJpaRepositories
public interface GenericRepository extends JpaRepository<GenericEntity, String> {
	Optional<GenericEntity> findById(String userId);

}

package com.scoder.hs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoder.hs.domain.entity.ReaIntroBoardEntity;

public interface ReaIntroBoardRepository extends JpaRepository<ReaIntroBoardEntity, String> {
	Optional<ReaIntroBoardEntity> findByUserId(String userId);
}

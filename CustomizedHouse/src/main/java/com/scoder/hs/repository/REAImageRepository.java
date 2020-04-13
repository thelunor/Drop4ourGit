package com.scoder.hs.repository;

import com.scoder.hs.domain.entity.REAImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface REAImageRepository extends JpaRepository<REAImageEntity, String> {
    Optional<REAImageEntity> findByUserId(String userId);
}

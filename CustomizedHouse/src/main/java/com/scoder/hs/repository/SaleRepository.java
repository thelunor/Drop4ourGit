package com.scoder.hs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.hs.domain.entity.SaleEntity;

@EnableJpaRepositories
public interface SaleRepository extends JpaRepository<SaleEntity, Integer>{
	
}

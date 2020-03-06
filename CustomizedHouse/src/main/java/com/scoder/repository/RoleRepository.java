package com.scoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.dto.Role;


@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, String> {
}

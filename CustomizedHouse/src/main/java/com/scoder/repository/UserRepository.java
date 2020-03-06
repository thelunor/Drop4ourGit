package com.scoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scoder.dto.User;


@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String> {
}

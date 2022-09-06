package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Users;

public interface userRepo extends JpaRepository<Users, Integer> {

	public Users findByUsername(String username);
}

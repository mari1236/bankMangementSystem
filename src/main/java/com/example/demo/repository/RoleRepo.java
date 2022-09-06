package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Roles;

public interface RoleRepo extends JpaRepository<Roles, Integer> {

}

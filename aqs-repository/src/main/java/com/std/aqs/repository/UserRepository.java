package com.std.aqs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.std.aqs.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

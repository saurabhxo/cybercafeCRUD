package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

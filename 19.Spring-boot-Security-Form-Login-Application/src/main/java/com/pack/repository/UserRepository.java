package com.pack.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.User;


public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByUsername(String username);
}
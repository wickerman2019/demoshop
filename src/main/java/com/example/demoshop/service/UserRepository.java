package com.example.demoshop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demoshop.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

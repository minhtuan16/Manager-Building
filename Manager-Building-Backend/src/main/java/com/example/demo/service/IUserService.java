package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.User;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}

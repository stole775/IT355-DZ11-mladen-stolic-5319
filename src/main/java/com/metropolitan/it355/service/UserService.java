package com.metropolitan.it355.service;

import com.metropolitan.it355.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    void save(User user);
}

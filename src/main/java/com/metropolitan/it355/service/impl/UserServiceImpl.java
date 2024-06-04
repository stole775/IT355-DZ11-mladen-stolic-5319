package com.metropolitan.it355.service.impl;


import com.metropolitan.it355.entity.User;
import com.metropolitan.it355.repository.UserRepository;
import com.metropolitan.it355.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

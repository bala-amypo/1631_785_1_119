

package com.example.demo.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repos;

    public UserServiceImpl(UserRepository repos) {
        this.repos = repos;
    }

    @Override
    public User register(User user) {
        // set createdAt
        user.setCreatedAt(LocalDateTime.now());

        // if role not provided, default MONITOR
        if (user.getRole() == null) {
            user.setRole("MONITOR");
        }

        // just save normally (no hashing, no validation)
        return repos.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repos.findByEmail(email);
    }
}

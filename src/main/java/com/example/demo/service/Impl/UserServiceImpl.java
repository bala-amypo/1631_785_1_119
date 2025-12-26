

package com.example.demo.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole("MONITOR");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResourceNotFoundException("Email already registered");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

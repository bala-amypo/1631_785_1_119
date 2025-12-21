package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
    User registerUser(User user);

    User findByEmail(String email);
    
    // Find user by ID
    User findById(Long id);
    
    // Get all users
    List<User> getAllUsers();
    
    // Update user
    User updateUser(Long id, User user);
    
    // Delete user
    void deleteUser(Long id);
}
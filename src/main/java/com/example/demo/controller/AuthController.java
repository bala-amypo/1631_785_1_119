package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
package com.example.demo.controller;

@RestController
public class AuthController {
    
    private final UserService userService;
    
    // Constructor injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    // POST /auth/register - Register a new user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
    // POST /auth/login - Login endpoint (simplified without JWT)
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        // Find user by email
        User user = userService.findByEmail(loginRequest.getEmail());
        
        // Simple password check (plain text comparison)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        
        // Return user details
        return user;
    }
    
    // GET /auth/user/{id} - Get user by ID (additional endpoint for testing)
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
    
    // GET /auth/user/email/{email} - Get user by email (additional endpoint)
    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
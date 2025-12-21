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
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return user;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
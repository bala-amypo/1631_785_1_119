  
package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User foundUser = userService.findByEmail(user.getEmail());

        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                foundUser.getEmail(),
                foundUser.getRole(),
                foundUser.getId()
        );

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(Map.of(
                        "token", token,
                        "message", "Login successful"
                ));
    }
}

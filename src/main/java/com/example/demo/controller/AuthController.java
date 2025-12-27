package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    // private final UserService userService;

    // public AuthController(UserService userService) {
    //     this.userService = userService;
    // }
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
        throw new IllegalArgumentException("Invalid credentials");
    }
     String token = jwtUtil.generateToken(
            foundUser.getEmail(),
            foundUser.getRole(),
            foundUser.getId()
    );

    return ResponseEntity.ok()
            .header("Authorization", "Bearer " + token)
            .body("Login successful");
    // return ResponseEntity.ok("Login successful");
    //  String token = jwtService.generateToken(foundUser.getEmail());

    // return ResponseEntity.ok()
    //         .header("Authorization", "Bearer " + token) // 👈 TOKEN HERE
    //         .body("Login successful");  
}
}

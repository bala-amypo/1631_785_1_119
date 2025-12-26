package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {    
        return "dummy.jwt.token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractEmail(String token) {
        return "test@mail.com";
    }

    public String extractRole(String token) {
        return "USER";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}

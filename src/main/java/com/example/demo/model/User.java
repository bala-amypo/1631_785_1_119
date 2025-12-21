
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String fullName;
    
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    
    @NotNull
    private String password;
    
    private String role;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    public void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        // Set default role to MONITOR if not provided
        if (this.role == null || this.role.isEmpty()) {
            this.role = "MONITOR";
        }
    }
}
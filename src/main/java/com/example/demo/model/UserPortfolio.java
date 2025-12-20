package com.example.demo.model;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class UserPortfolio{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private Long userId;
    @NotBlank(message="Portfolio name must not be blank")
    @Column(name="portfolioName",)
    private String portfolioName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean action;
     

}
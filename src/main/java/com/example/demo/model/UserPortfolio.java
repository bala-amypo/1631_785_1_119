package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_portfolios")
public class UserPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private String portfolioName;
    private boolean isActive;

    @PrePersist
    public void Oncreate(){
        LocalDateTime now= LocalDateTime.now();
        if(this.createdAt==null){
        this.createdAt=now;
        }
        this.updatedAt=now;
    }
    @PreUpdate
    public void Onupdate(){
        LocalDateTime now= LocalDateTime.now();
        this.updatedAt=now;
    }
}
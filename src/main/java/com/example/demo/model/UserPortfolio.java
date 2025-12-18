package com.example.demo.model;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserPortfolio{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private Long userId;
    @NotBlank
    private String portfolioName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean action;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPortfolioName() {
        return portfolioName;
    }
    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public boolean isAction() {
        return action;
    }
    public void setAction(boolean action) {
        this.action = action;
    }
    public UserPortfolio(Long id, Long userId,@NotBlank String portfolioName, Timestamp createdAt, Timestamp updatedAt,
            boolean action) {
        this.id = id;
        this.userId = userId;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.action = action;
    }
    public UserPortfolio() {
    } 
}
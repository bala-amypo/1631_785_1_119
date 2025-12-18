package com.example.demo.model;
public class UserPortfolio{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private Long userId;
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
    public UserPortfolio(Long id, Long userId, String portfolioName, Timestamp createdAt, Timestamp updatedAt,
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
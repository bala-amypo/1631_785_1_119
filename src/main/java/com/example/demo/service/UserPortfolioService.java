package com.example.demo.service;
import com.example.demo.model.UserPortfolio;
public interface UserPortfolioService{
    UserPortfolio createPortfolio(UserPortfolio portfolio);
    UserPortfolio updatePortfolio(Long id,UserPortfolio portfolio );
    UserPortfolio getPortfolioById(Long id);
    UserPortfolio getPortfoliosById(Long id);
    String DeleteData(int id);
    
    

}
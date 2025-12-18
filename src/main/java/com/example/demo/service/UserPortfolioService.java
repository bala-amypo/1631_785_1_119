package com.example.demo.service;
import com.example.demo.model.UserPortfolio;
public interface UserPortfolioService{
    UserPortfolio createPortfolio(UserPortfolio portfolio);
    String DeleteData(int id);
    StudentEntity getData(int id);
    StudentEntity updateData(int id,StudentEntity entity);

}
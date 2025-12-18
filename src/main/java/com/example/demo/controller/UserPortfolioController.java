package com.example.demo.controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
public class UserPortfolioController
{
    @Autowired UserPortfolioService ser;
    @PostMapping("/poster")
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }
    @PutMapping("/put/{id}")
    public StudentEntity updateVal(@PathVariable int id,@RequestBody StudentEntity entity){
        return ser.updateData(id,entity);
    }

}
package com.example.demo.controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserPortfolioController
{
    @Autowired UserPortfolioService ser;
    @PostMapping("/Post1")
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }
    @PutMapping("/Put!/{id}")
    public UserPortfolio updatePortfolio(@PathVariable int id,@RequestBody UserPortfolio model){
        return ser.update(id,model);
    }

}
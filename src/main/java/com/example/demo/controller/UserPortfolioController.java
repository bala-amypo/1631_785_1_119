package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserPortfolioController{
    @Autowired UserPortfolioService ser;
    @PostMapping("/post")
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }

}
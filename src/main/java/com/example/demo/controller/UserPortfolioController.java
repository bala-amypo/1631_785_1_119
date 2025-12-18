package com.example.demo.controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public UserPortfolio create_Portfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }
    @PutMapping("/Put1/{id}")
    public UserPortfolio update_Portfolio(@PathVariable Long id,@RequestBody UserPortfolio model){
        return ser.updatePortfolio(id,model);
    }
    @GetMapping("/getid1/{id}")
    public UserPortfolio get_PortfolioById(@PathVariable Long id){
        return ser.getPortfolioById(id);
    }
    @GetMapping("/get_userid1/{userId}")
    public UserPortfolio get_PortfoliosByUser(@PathVariable Long userId){
        return ser.getPortfoliosByUser(userId);
    }
}
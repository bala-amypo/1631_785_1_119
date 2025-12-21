
package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RiskAnalysisResultController
{
    @Autowired UserPortfolioService ser;
    @PostMapping("/Post_RiskAnalysisResult")
    public UserPortfolio create_Portfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }
    
    @GetMapping("/getid_RiskAnalysisResult/{id}")
    public UserPortfolio get_PortfolioById(@PathVariable Long id){
        return ser.getPortfolioById(id);
    }
    @GetMapping("/getall_RiskAnalysisResult/user/{userId}")
    public List<UserPortfolio> get_PortfoliosByUser(){
        return ser.getPortfoliosByUser();
    }

}

package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RiskAnalysisController
{
    private final RiskAnalysisService ser;
    
    public RiskAnalysisController(RiskAnalysisService ser) {
        this.ser = ser;
    }
    // @PostMapping("/Post_PortfolioHolding")
    // public PortfolioHolding create_Holding(@RequestBody PortfolioHolding Holding){
    //     return ser.createHolding(Holding);
    // }
    
    @GetMapping("/getid_analysis/{id}")
    public PortfolioHolding get_HoldingById(@PathVariable Long id){
        return ser.getHoldingById(id);
    }
    @GetMapping("/getall_PortfolioHolding/portfolio/{portfolioId}")
    public List<PortfolioHolding> get_HoldingsByPortfolio(){
        return ser.getHoldingsByPortfolio();
    }
    

}
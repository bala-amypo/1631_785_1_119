
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
    @PostMapping("/Post_analysis/analyze/{portfolioId}")
    public RiskAnalysisResult analyze_Portfolio(@PathVariable Long portfolioId){
        return ser.analyzePortfolio(ortfolios);
    }


    
    @GetMapping("/getid_analysis/{id}")
    public RiskAnalysisResult get_AnalysisById(@PathVariable Long id){
        return ser.getAnalysisById(id);
    }
    @GetMapping("/getall_analysis/portfolio/{portfolioId}")
    public List<RiskAnalysisResult>get_AnalysesForPortfolio(){
        return ser.getAnalysesForPortfolio();
    }
    

}
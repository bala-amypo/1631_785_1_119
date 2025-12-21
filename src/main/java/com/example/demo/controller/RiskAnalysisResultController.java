
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
    private final RiskAnalysisResultService ser;
    public RiskAnalysisResultController(RiskAnalysisResultService ser){
        this.ser=ser;
    }
    @PostMapping("/Post_Analysis/analyze/{portfolioId}")
    public RiskAnalysisResult analyze_Portfolio(@RequestBody RiskAnalysisResultRepository Results){
        return ser.analyzePortfolio(portfolioId);
    }
    
    @GetMapping("/getid_Analysis/{id}")
    public RiskAnalysisResult get_AnalysisById(@PathVariable Long id){
        return ser.getAnalysisById(id);
    }
    @GetMapping("/getall_Analysis/portfolio/{ortfolioId}")
    public List<RiskAnalysisResult>get_AnalysesForPortfolio(@PathVariable Long portfolioId){
        return ser.getAnalysesForPortfolio(portfolioId);
    }

}
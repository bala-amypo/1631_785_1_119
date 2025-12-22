
package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {
    
    private final RiskAnalysisService analysisService;
    
    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }
    
    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId, @RequestBody RiskAnalysisResult analysisRequest) {
        return analysisService.analyzePortfolio(portfolioId, analysisRequest);
    }
    
    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysesForPortfolio(@PathVariable Long portfolioId) {
        return analysisService.getAnalysesForPortfolio(portfolioId);
    }
    
    @GetMapping("/result/{id}")
    public RiskAnalysisResult getAnalysisById(@PathVariable Long id) {
        return analysisService.getAnalysisById(id);
    }
}
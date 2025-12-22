package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public RiskAnalysisResult analyzePortfolio(@RequestBody RiskAnalysisResult analysisRequest) {
        return analysisService.analyzePortfolio(analysisRequest);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysesForPortfolio(@PathVariable Long portfolioId) {
        return analysisService.getAnalysesForPortfolio(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getAnalysisById(@PathVariable Long id) {
        return analysisService.getAnalysisById(id);
    }
}

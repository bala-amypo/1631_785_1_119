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
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(
            @RequestBody RiskAnalysisResult analysisRequest) {
        return ResponseEntity.ok(analysisService.analyzePortfolio(analysisRequest));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(analysisService.getAnalysesForPortfolio(portfolioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getAnalysisById(@PathVariable Long id) {
        return ResponseEntity.ok(analysisService.getAnalysisById(id));
    }
}

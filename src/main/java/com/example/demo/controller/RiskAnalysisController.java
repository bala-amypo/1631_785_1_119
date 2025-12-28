package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    // ✅ FIXED: NO RequestBody
    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(
            @PathVariable Long portfolioId) {

        RiskAnalysisResult result =
                analysisService.analyzePortfolio(portfolioId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(
            @PathVariable Long portfolioId) {

        List<RiskAnalysisResult> results =
                analysisService.getAnalysesForPortfolio(portfolioId);

        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getAnalysisById(
            @PathVariable Long id) {

        RiskAnalysisResult result =
                analysisService.getAnalysisById(id);

        return ResponseEntity.ok(result);
    }
}

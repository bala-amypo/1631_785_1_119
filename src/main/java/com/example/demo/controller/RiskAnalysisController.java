package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PreAuthorize("hasRole('QUALITY_AUDITOR')")
    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(analysisService.analyzePortfolio(portfolioId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(analysisService.getAnalysesForPortfolio(portfolioId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getAnalysisById(@PathVariable Long id) {
        return ResponseEntity.ok(analysisService.getAnalysisById(id));
    }
}

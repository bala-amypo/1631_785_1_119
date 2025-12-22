
package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {
    
    private final RiskThresholdService thresholdService;
    
    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }
    
    @PostMapping("/{portfolioId}")
    public RiskThreshold setThreshold(@PathVariable Long portfolioId, @RequestBody RiskThreshold threshold) {
        return thresholdService.setThreshold(portfolioId, threshold);
    }
    
    @GetMapping("/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return thresholdService.getThresholdForPortfolio(portfolioId);
    }
}

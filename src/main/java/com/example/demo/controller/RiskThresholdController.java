package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable Long id,@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
        return ResponseEntity.ok(thresholdService.getThresholdById(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<RiskThreshold>> getActiveThresholds() {
        return ResponseEntity.ok(thresholdService.getActiveThreshold());
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        return ResponseEntity.ok(thresholdService.getAllThresholds());
    }
}

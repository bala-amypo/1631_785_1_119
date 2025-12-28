package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> updateThreshold(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
        return ResponseEntity.ok(thresholdService.getThresholdById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/active")
    public ResponseEntity<List<RiskThreshold>> getActiveThresholds() {
        return ResponseEntity.ok(thresholdService.getActiveThreshold());
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        return ResponseEntity.ok(thresholdService.getAllThresholds());
    }
}

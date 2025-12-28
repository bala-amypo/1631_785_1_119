package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR')")
    @PostMapping
    public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.createHolding(holding));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> updateHolding(
            @PathVariable Long id,
            @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.updateHolding(id, holding));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getHolding(@PathVariable Long id) {
        return ResponseEntity.ok(holdingService.getHoldingById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long id) {
        holdingService.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}

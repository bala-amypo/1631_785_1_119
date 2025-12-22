package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    // Create a new holding
    @PostMapping
    public PortfolioHolding createHolding(@RequestBody PortfolioHolding holding) {
        return holdingService.createHolding(holding);
    }

    // Update an existing holding
    @PutMapping("/{id}")
    public PortfolioHolding updateHolding(@PathVariable Long id, @RequestBody PortfolioHolding holding) {
        return holdingService.updateHolding(id, holding);
    }

    // Get a holding by ID
    @GetMapping("/{id}")
    public PortfolioHolding getHolding(@PathVariable Long id) {
        return holdingService.getHoldingById(id);
    }

    // Get all holdings
    @GetMapping
    public List<PortfolioHolding> getAllHoldings() {
        return holdingService.getHoldingsByPortfolio();
    }

    // Delete or deactivate a holding
    @DeleteMapping("/{id}")
    public String deleteHolding(@PathVariable Long id) {
        return holdingService.deleteHolding(id);
    }
}

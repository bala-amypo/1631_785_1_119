
package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {
    
    private final PortfolioHoldingService holdingService;
    
    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }
    
    @PostMapping
    public PortfolioHolding createHolding(@RequestBody PortfolioHolding holding) {
        return holdingService.createHolding(holding);
    }
    
    @PutMapping("/{id}")
    public PortfolioHolding updateHolding(@PathVariable Long id, @RequestBody PortfolioHolding holding) {
        return holdingService.updateHolding(id, holding);
    }
    
    @GetMapping("/{id}")
    public PortfolioHolding getHolding(@PathVariable Long id) {
        return holdingService.getHoldingById(id);
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }
    
    @DeleteMapping("/{id}")
    public void deleteHolding(@PathVariable Long id) {
        holdingService.deleteHolding(id);
    }
}
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR')")
    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR','QUALITY_AUDITOR')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosByUser(@PathVariable Long userId) {
        List<UserPortfolio> portfolios = portfolioService.getPortfoliosByUser(userId);
        return ResponseEntity.ok(portfolios);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MONITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<UserPortfolio> updatePortfolio(
            @PathVariable Long id,
            @RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolio));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivatePortfolio(@PathVariable Long id) {
        portfolioService.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}

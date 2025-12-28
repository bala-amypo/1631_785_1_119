package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    // ✅ REQUIRED constructor order (do NOT change)
    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepository,
            UserPortfolioRepository portfolioRepository,
            StockRepository stockRepository
    ) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {

        // ✅ REQUIRED validation
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        return holdingRepository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {

        PortfolioHolding existing = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        existing.setPortfolio(holding.getPortfolio());
        existing.setStock(holding.getStock());

        return holdingRepository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }

    @Override
    public String deleteHolding(Long id) {
        holdingRepository.deleteById(id);
        return "delete successfully";
    }
}

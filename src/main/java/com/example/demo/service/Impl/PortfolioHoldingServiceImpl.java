package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    
    private final PortfolioHoldingRepository holdingRepository;
    
    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }
    
    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if(holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        
        if(holding.getMarketValue() == null || holding.getMarketValue().doubleValue() < 0) {
            throw new IllegalArgumentException("Market value must be 0 or positive");
        }
        
        return holdingRepository.save(holding);
    }
    
    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existingHolding = holdingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
        
        if(holding.getQuantity() != null) {
            if(holding.getQuantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            existingHolding.setQuantity(holding.getQuantity());
        }
        
        if(holding.getMarketValue() != null) {
            if(holding.getMarketValue().doubleValue() < 0) {
                throw new IllegalArgumentException("Market value must be 0 or positive");
            }
            existingHolding.setMarketValue(holding.getMarketValue());
        }
        
        if(holding.getPortfolioId() != null) {
            existingHolding.setPortfolioId(holding.getPortfolioId());
        }
        
        if(holding.getStockId() != null) {
            existingHolding.setStockId(holding.getStockId());
        }
        
        return holdingRepository.save(existingHolding);
    }
    
    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
    }
    
    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }
    
    @Override
    public String deleteHolding(Long id) {
        PortfolioHolding holding = holdingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
        
        holdingRepository.delete(holding);
    }
}
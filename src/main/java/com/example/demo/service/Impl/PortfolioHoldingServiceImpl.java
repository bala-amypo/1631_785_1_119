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
    public PortfolioHolding createHolding(PortfolioHolding holding){
        return holdingRepository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding){
        PortfolioHolding existing = holdingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio Holding not found"));

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        existing.setPortfolio(holding.getPortfolio());
        existing.setStock(holding.getStock());

        return holdingRepository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id){
        return holdingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio Holding not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId){
        return holdingRepository.findByPortfolio_Id(portfolioId);
    }

    @Override
    public String deleteHolding(Long id){
        holdingRepository.deleteById(id);
        return "delete successfully";
    }
}

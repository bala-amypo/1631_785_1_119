package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService{
    private final PortfolioHoldingRepository holdingRepository;
    
    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }
    // @Override
    // public PortfolioHolding createHolding(PortfolioHolding Holding){
    //     return holdingRepository.save(Holding);
    // }
    
    
   @Override
   public PortfolioHolding getHoldingById(Long id){
        return holdingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(" Portfolio Not found"));

   }
    @Override
   public List<PortfolioHolding>getHoldingsByPortfolio(){
        return holdingRepository.findAll();

   }
   


}
package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService{
    private final RiskAnalysisResultRepository result;
    
    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository holdingRepository) {
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
package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDateTime;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService{
    private final RiskAnalysisResultRepository result;
    
    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository result) {
        this.result = result;
    }
     @Override
    public RiskAnalysisResult analyzePortfolio(RiskAnalysisResult portfolios) {
        return result.save(portfolios);
    
    }
    
    
   @Override
   public RiskAnalysisResult getAnalysisById(Long id){
        return result.findById(id).orElseThrow(()->new ResourceNotFoundException(" Portfolio Not found"));

   }
    @Override
   public List<RiskAnalysisResult> getAnalysesForPortfolio(){
        return result.findAll();

   }
   


}
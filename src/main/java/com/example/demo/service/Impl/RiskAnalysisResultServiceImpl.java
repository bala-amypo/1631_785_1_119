
package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService{
    @Autowired RiskAnalysisResultRepository Results;
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId){
        return Results.save(portfolioId);
    }
       
   @Override
   public RiskAnalysisResult getAnalysisById(Long id){
        return Results.findById(id).orElseThrow(()->new ResourceNotFoundException("Result Not found"));

   }
    @Override
   public List<RiskAnalysisResult>getAnalysesForPortfolio(Long portfolioId){
        return Results.findAll();

   }

}
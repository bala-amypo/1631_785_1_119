// package com.example.demo.service.Impl;
// public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService {
    
// }
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
    @Autowired RiskAnalysisResultRepository Result;
    @Override
    public RiskAnalysisResult analyzePortfolio(RiskAnalysisResult Result){
        return Results.save(Result);
    }
    @Override
   public RiskThreshold updateThreshold(Long id,RiskThreshold threshold){
        if(thresholds.existsById(id)){
            threshold.setId(id);
            return thresholds.save(threshold);
        }
        return null;
   }
    @Override
    public List<RiskThreshold> getActiveThreshold(){
        return thresholds.findByActiveTrue();
    }
   @Override
   public RiskThreshold getThresholdById(Long id){
        return thresholds.findById(id).orElseThrow(()->new ResourceNotFoundException("Portfolio Not found"));

   }
    @Override
   public List<RiskThreshold>getAllThresholds(){
        return thresholds.findAll();

   }


}
package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService{
    @Autowired RiskThresholdRepository thresholds;
    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold){
        return thresholds.save(threshold);
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
    public RiskThreshold getActiveThreshold(){
        return thresholds.findByActiveTrue().orElseThrow(()->new ResourceNotFoundException("Portfolio Not found"));
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
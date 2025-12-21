
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
     private final RiskAnalysisResultRepository Results;
     private final UserPortfolioRepository Upr;

    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository Results,UserPortfolioRepository Upr){
            this.Results=Results;
            this.Upr=Upr;
    }
    
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId){
          Upr.findById(portfolioId).orElseThrow(()->new ResourceNotFoundException("Portfolio Not found"));
          RiskAnalysisResult result=new RiskAnalysisResult();
          result.setPortfolioId(
         return Results.save(result);
     }

       
   @Override
   public RiskAnalysisResult getAnalysisById(Long id){
        return Results.findById(id).orElseThrow(()->new ResourceNotFoundException("Portfolio Not found"));

   }
    @Override
   public List<RiskAnalysisResult>getAnalysesForPortfolio(Long portfolioId){
        return Results.findByPortfolioId(portfolioId);

   }

}
// public First first;
// @Autowired
// public Second(First first){
//     this.first=first;
//     this.first.name="John";
//     this.first.age=30;
// }
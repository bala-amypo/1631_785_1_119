
package com.example.demo.service.Impl;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService{
    private final RiskAnalysisResultRepository Results;
    private final UserPortfolioRepository portfolio_repo;
    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository Results,UserPortfolioRepository portfolio_repo){
     this.RiskAnalysisResultRepository=Results;
     this.UserPortfolioRepository=portfolio_rep;
    }
    
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId){
     UserPortfolio portfolio=portfolio_repo.findById(portfolioId).orElseThrow(()->new ResourceNotFoundException("Result Not found"));
         return Results.save(portfolioId);
     }
       
   @Override
   public RiskAnalysisResult getAnalysisById(Long id){
        return Results.findById(id).orElseThrow(()->new ResourceNotFoundException("Result Not found"));

   }
    @Override
   public List<RiskAnalysisResult>getAnalysesForPortfolio(Long portfolioId){
        return Results.findByPortfolioId(portfolioId);

   }

}

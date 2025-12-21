
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
    private final UserPortfolioRepository portfolio_repo;
    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository Results,UserPortfolioRepository portfolio_repo){
     this.RiskAnalysisResultRepository=Results;
     this.UserPortfolioRepository=portfolio_rep;
    }
    
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId){
     UserPortfolio portfolio=portfolio_repo.findById()
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

// UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
//             .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id " + portfolioId));

//         RiskAnalysisResult analysis = new RiskAnalysisResult();
//         analysis.setPortfolio(portfolio);
//         analysis.setHighestStockPercentage(50.0);  // example
//         analysis.setHighestSectorPercentage(60.0); // example
//         analysis.setHighRisk(true);
//         analysis.setNotes("Sample analysis");

//         return results.save(analysis);


//     @Autowired
//     private UserPortfolioRepository portfolioRepository;
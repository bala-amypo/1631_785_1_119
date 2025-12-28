// package com.example.demo.service.Impl; 
// import org.springframework.stereotype.Service; 
// import java.util.List; 
// import com.example.demo.model.RiskAnalysisResult; 
// import com.example.demo.service.RiskAnalysisService; 
// import com.example.demo.repository.RiskAnalysisResultRepository; 
// import com.example.demo.exception.ResourceNotFoundException;
// import java.time.LocalDateTime;

// @Service
// public class RiskAnalysisServiceImpl implements RiskAnalysisService {

//     private final RiskAnalysisResultRepository resultRepository;

//     public RiskAnalysisServiceImpl(RiskAnalysisResultRepository resultRepository) {
//         this.resultRepository = resultRepository;
//     }

//     @Override
//     public RiskAnalysisResult analyzePortfolio(RiskAnalysisResult analysis) {
//         if (analysis.getAnalysisTime() == null) {
//             analysis.setAnalysisTime(LocalDateTime.now());
//         }
//         return resultRepository.save(analysis);
//     }


//     @Override
//     public RiskAnalysisResult getAnalysisById(Long id) {
//         return resultRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Portfolio analysis not found"));
//     }

//     @Override
//     public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
//         return resultRepository.findByPortfolioId(portfolioId);
//     }
// }

package com.example.demo.service.Impl; 
import org.springframework.stereotype.Service; 
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository resultRepository,
            UserPortfolioRepository portfolioRepository,
            PortfolioHoldingRepository holdingRepository,
            RiskThresholdRepository thresholdRepository
    ) {
        this.resultRepository = resultRepository;
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
    }

    // ✅ Modified to match interface
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        List<PortfolioHolding> holdings = holdingRepository.findByPortfolioId(portfolioId);

        double totalValue = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue())
                .sum();

        double highestStockPct = holdings.stream()
                .mapToDouble(h -> (h.getMarketValue().doubleValue() / totalValue) * 100)
                .max()
                .orElse(0);

        Map<String, Double> sectorTotals = holdings.stream()
                .collect(Collectors.groupingBy(
                        h -> h.getStock().getSector(),
                        Collectors.summingDouble(h -> h.getMarketValue().doubleValue())
                ));

        double highestSectorPct = sectorTotals.values().stream()
                .mapToDouble(v -> (v / totalValue) * 100)
                .max()
                .orElse(0);

        RiskThreshold threshold = thresholdRepository.findByActiveTrue()
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Active threshold not found"));

        boolean isHighRisk = highestStockPct > threshold.getMaxSingleStockPercentage()
                || highestSectorPct > threshold.getMaxSectorPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisTime(LocalDateTime.now());
        result.setHighestStockPercentage(highestStockPct);
        result.setHighestSectorPercentage(highestSectorPct);
        result.setHighRisk(isHighRisk);
        result.setNotes(isHighRisk ? "Portfolio exceeds risk thresholds" : "Within risk limits");

        return resultRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolioId(portfolioId);
    }
}

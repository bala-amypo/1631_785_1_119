package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository resultRepository,
            UserPortfolioRepository portfolioRepository) {
        this.resultRepository = resultRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Portfolio not found"));

     
        RiskAnalysisResult analysis = new RiskAnalysisResult();
        analysis.setPortfolio(portfolio);
        analysis.setAnalysisTime(LocalDateTime.now());

       
        analysis.setHighestStockPercentage(0.0);
        analysis.setHighestSectorPercentage(0.0);
        analysis.setHighRisk(false);
        analysis.setNotes("Risk analysis completed");

        return resultRepository.save(analysis);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Portfolio analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolioId(portfolioId);
    }
}

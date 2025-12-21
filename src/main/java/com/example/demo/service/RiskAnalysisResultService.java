
package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskAnalysisResult;
public interface RiskAnalysisResultService{
    RiskAnalysisResult analyzePortfolio(Long portfolioId);
    RiskAnalysisResult getAnalysisById(Long id);
    List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId);
}
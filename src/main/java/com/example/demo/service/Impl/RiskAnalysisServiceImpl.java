package com.example.demo.service.Impl; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.example.demo.model.RiskAnalysisResult; 
import com.example.demo.service.RiskAnalysisService; 
import com.example.demo.repository.RiskAnalysisResultRepository; 
import com.example.demo.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(RiskAnalysisResult analysis) {
        if (analysis.getAnalysis() == null) {
            analysis.setAnalysis(LocalDateTime.now());
        }
        return resultRepository.save(analysis);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return resultRepository.findByPortfolio_Id(portfolioId);
    }
}

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(RiskAnalysisResult analysis) {
        // Automatically sets analysis date if not provided
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

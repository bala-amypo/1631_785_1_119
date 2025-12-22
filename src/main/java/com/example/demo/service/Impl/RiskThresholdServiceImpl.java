@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = thresholdRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        existing.setThresholdName(threshold.getThresholdName());
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.isActive());

        return thresholdRepository.save(existing);
    }

    @Override
    public List<RiskThreshold> getActiveThreshold() {
        return thresholdRepository.findByActiveTrue();
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return thresholdRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}

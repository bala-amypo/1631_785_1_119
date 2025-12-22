@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        if (stockRepository.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker");
        }
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        existingStock.setTicker(stock.getTicker());
        existingStock.setCompanyName(stock.getCompanyName());
        existingStock.setSector(stock.getSector());
        existingStock.setIsActive(stock.getIsActive());

        return stockRepository.save(existingStock);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public String deactivateStock(Long id) {
        Stock stock = stockRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        stock.setIsActive(false);
        stockRepository.save(stock);

        return "Stock deactivated successfully";
    }
}

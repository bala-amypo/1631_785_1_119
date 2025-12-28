// package com.example.demo.service.Impl; 
// import org.springframework.stereotype.Service; 
// import java.util.List; 
// import com.example.demo.model.Stock; 
// import com.example.demo.service.StockService; 
// import com.example.demo.repository.StockRepository; 
// import com.example.demo.exception.ResourceNotFoundException;
// @Service
// public class StockServiceImpl implements StockService {

//     private final StockRepository stockRepository;

//     public StockServiceImpl(StockRepository stockRepository) {
//         this.stockRepository = stockRepository;
//     }

//     @Override
//     public Stock createStock(Stock stock) {
//         if (stockRepository.findByTicker(stock.getTicker()).isPresent()) {
//             throw new ResourceNotFoundException("Duplicate ticker");
//         }
//         return stockRepository.save(stock);
//     }

//     @Override
//     public Stock updateStock(Long id, Stock stock) {
//         Stock existingStock = stockRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

//         existingStock.setTicker(stock.getTicker());
//         existingStock.setCompanyName(stock.getCompanyName());
//         existingStock.setSector(stock.getSector());
//         existingStock.setActive(stock.isActive());

//         return stockRepository.save(existingStock);
//     }

//     @Override
//     public Stock getStockById(Long id) {
//         return stockRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
//     }

//     @Override
//     public List<Stock> getAllStocks() {
//         return stockRepository.findAll();
//     }

//     @Override
// public void deactivateStock(Long id) {   
//     Stock stock = stockRepository.findById(id)
//         .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

//     stock.setActive(false);
//     stockRepository.save(stock);
// }

// }
package com.example.demo.service.Impl; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.example.demo.model.Stock; 
import com.example.demo.service.StockService; 
import com.example.demo.repository.StockRepository; 
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        // ✅ Minimal fix: throw correct exception message
        if (stockRepository.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker"); // match test case exactly
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
        existingStock.setActive(stock.isActive());

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
    public void deactivateStock(Long id) {   
        Stock stock = stockRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        stock.setActive(false);
        stockRepository.save(stock);
    }
}

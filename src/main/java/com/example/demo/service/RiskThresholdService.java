
package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskThreshold;
public interface StockService{
    RiskThreshold createStock(RiskThreshold threshold);
    RiskThreshold updateStock(Long id,RiskThreshold threshold);
    RiskThreshold getStockById(Long id);
    List<RiskThreshold>getAllStocks();
    
}
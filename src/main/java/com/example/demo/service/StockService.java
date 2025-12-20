package com.example.demo.service;
import com.example.demo.model.Stock;
public interface StockService{
    Stock createStock(Stock stock);
    Stock updateStock(Long id,Stock stock);
    Stock getStockById(Long id);
    List<Stock>getPortfoliosByUser();
}
package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import com.example.demo.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
    @Autowired StockRepository stocks;
    @Override
    public Stock createStock(Stock stock){
        return stocks.save(stock);
    }
    @Override
   public Stock updateStock(Long id,Stock stock){
        if(stocks.existsById(id)){
            stock.setId(id);
            return stocks.save(stock);
        }
        return null;
   }
    
   @Override
   public Stock getStockById(Long id){
        return stocks.findById(id).orElseThrow(()->new ResourceNotFoundException("Duplicate ticker"));

   }
    @Override
   public List<Stock>getAllStocks(){
        return stocks.findAll();

   }
   @Override
    public String deactivateStock(Long id){
        stocks.deleteById(id);
        return "delete successfully";

    }


}
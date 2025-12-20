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
   public UserPortfolio updatePortfolio(Long id,UserPortfolio portfolio){
        if(port_folio.existsById(id)){
            portfolio.setId(id);
            return port_folio.save(portfolio);
        }
        return null;
   }
    
   @Override
   public UserPortfolio getPortfolioById(Long id){
        return port_folio.findById(id).orElse(null);

   }
    @Override
   public List<UserPortfolio>getPortfoliosByUser(){
        return port_folio.findAll();

   }
   @Override
    public String deactivatePortfolio(Long id){
        port_folio.deleteById(id);
        return "delete successfully";

    }


}
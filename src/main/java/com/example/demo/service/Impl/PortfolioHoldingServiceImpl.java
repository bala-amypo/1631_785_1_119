package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService{
    @Autowired UserPortfolioRepository port_folio;
    @Override
    public PortfolioHolding createPortfolio(PortfolioHolding portfolio){
        return port_folio.save(portfolio);
    }
    @Override
   public PortfolioHolding updatePortfolio(Long id,PortfolioHolding portfolio){
        if(port_folio.existsById(id)){
            portfolio.setId(id);
            return port_folio.save(portfolio);
        }
        return null;
   }
    
   @Override
   public UserPortfolio getPortfolioById(Long id){
        return port_folio.findById(id).orElseThrow(()->new ResourceNotFoundException(" Portfolio Not found"));

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
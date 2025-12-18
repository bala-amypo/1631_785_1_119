package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import com.example.demo.repository.UserPortfolioRepository;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService{
    @Autowired UserPortfolioRepository port_folio;
    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio){
        return port_folio.save(portfolio);
    }
    @Override
   public UserPortfolio updatePortfolio(Long id,UserPortfolio portfolio){
        if(port_folio.existsById(id)){
            model.setId(id);
            return port_folio.save(model);
        }
        return null;
   }

}
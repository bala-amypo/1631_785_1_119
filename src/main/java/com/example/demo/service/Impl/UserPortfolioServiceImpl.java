package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository portFolioRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository portFolioRepository) {
        this.portFolioRepository = portFolioRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portFolioRepository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = portFolioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        existing.setPortfolioName(portfolio.getPortfolioName());
        existing.setActive(portfolio.getActive()); // ✅ FIXED
        existing.setUser(portfolio.getUser());

        return portFolioRepository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return portFolioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return portFolioRepository.findByUserId(userId);
    }

    @Override
    public String deactivatePortfolio(Long id) {
        UserPortfolio portfolio = portFolioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        portfolio.setActive(false);
        portFolioRepository.save(portfolio);
        return "Portfolio deactivated successfully";
    }
}

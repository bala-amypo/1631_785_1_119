package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "portfolio_holdings")
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long portfolioId;
    private Long stockId;
    private Double quantity;
    private BigDecimal marketValue;
    
    
    private UserPortfolio portfolio;
    private Stock stock;

    @PrePersist
    public void Oncreated() {
        
        if(this.lastUpdated == null) {
            LocalDateTime last= LocalDateTime.now();
            this.lastUpdated = last;
        }
    }
}
    
    

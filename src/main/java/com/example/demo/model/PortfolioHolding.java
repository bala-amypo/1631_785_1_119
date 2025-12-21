
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PortfolioHolding {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long portfolioId;
    
    private Long stockId;
    
    private Double quantity;
    
    private BigDecimal marketValue;
    
    private  LocalDateTime lastUpdated;
    
    @PrePersist
    public void setTimestamp() {
        if(lastUpdated == null) {
            lastUpdated = new Timestamp(System.currentTimeMillis());
        }
    }
    
    @PreUpdate
    public void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }
}
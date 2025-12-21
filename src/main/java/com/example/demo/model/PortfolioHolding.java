
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PrePersist;

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
    public void Oncreated() {
        LocalDateTime last= LocalDateTime.now();
        if(this.lastUpdated == null) {
            this.lastUpdated = last;
        }
    }
    
    @PreUpdate
    public void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }
}
package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RiskAnalysisResult{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long portfolioId;
    private LocalDateTime analysis;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean isHighRisk;
    private String notes;
    @ManyToOne     
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;
    @PrePersist
    public void Onrecord(){
        if(this.analysis == null){
            LocalDateTime resulted= LocalDateTime.now();
            this.analysis=resulted;
        }
    }

}
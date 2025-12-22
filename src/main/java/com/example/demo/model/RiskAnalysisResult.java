package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean highRisk;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;

    @PrePersist
    public void onRecord() {
        if (this.analysisDate == null) {
            this.analysisDate = LocalDateTime.now();
        }
    }
}

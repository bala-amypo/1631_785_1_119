package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime analysisTime;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean highRisk;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    @JsonBackReference
    private UserPortfolio portfolio;

    @PrePersist
    public void onRecord() {
        if (this.analysisTime == null) {
            this.analysisTime = LocalDateTime.now();
        }
    }

    public void setAnalysisDate(Timestamp timestamp) {
        if (timestamp != null) {
            this.analysisTime = timestamp.toLocalDateTime();
        }
    }

    public Timestamp getAnalysisDate() {
        return analysisTime != null
                ? Timestamp.valueOf(analysisTime)
                : null;
    }
}

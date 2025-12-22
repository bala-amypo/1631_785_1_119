package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class RiskThreshold{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "thresholdName",unique = true)
    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    // private Double maxOverallVolatility;
    @NotNull
    private boolean active;

}
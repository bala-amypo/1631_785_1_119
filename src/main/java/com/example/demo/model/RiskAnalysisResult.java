package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import java.sql.Timestamp;
import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor




public class RiskAnalysisResult{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;
    private LocalDateTime analysis;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean isHighRisk;
    private String notes;
     @PrePersist
    public void Oncreate(){
         LocalDateTime now= LocalDateTime.now();
    }

}
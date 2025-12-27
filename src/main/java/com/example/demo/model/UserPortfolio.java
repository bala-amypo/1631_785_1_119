package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "user_portfolios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String portfolioName;
    @Column(name = "is_active", nullable = false)
private boolean active = true;

    // private boolean active=true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

  @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<PortfolioHolding> holdings;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<RiskAnalysisResult> riskAnalyses;
    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();


        if (this.createdAt == null) {
            this.createdAt = now;
        }
        this.updatedAt = now;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
   
}
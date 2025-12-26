package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stocks")

public class Stock{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ticker",unique = true)
    private String ticker;
    private String companyName;
    private String sector;
    private boolean isActive;
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<PortfolioHolding> holdings;
}
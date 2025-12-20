package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;
import jakarta.persistence.PreUpdate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserPortfolio{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="User Id must not be null")
    private Long userId;

    @NotBlank(message="Portfolio name must not be blank")
    @Column(name = "portfolioName",unique = true)
    private String portfolioName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean action;

    @PrePersist
    public void Oncreate(){
        LocalDateTime now= LocalDateTime.now();
        if(this.createdAt==null){
        this.createdAt=now;
        }
        this.updatedAt=now;
    }
    @PreUpdate
    public void Onupdate(){
        LocalDateTime now= LocalDateTime.now();
        this.updatedAt=now;
    }
}
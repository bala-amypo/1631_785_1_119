
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.RiskThreshold;
@Repository
public interface RiskThresholdRepository extends JpaRepository<RiskThreshold,Long>{
       OpRiskThreshold findByActiveTrue();
}

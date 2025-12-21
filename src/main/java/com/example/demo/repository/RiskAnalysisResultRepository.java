

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.RiskAnalysisResult;
@Repository
public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult,Long>{

}

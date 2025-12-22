package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Stock;
import java.util.List;
import java.util.Optional;
@Repository
public interface StockRepository extends JpaRepository<Stock,Long>{
    Optional<Stock> findByTicker(String ticker);
    List<Stock> findBySector(String sector);

}

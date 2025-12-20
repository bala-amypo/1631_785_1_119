package com.example.demo.service;
import com.example.demo.entity.Stock;
public interface StockService{
    ValidationEntity postData(ValidationEntity valid);
    ValidationEntity getData(Long id);
}

package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StockController
{
    @Autowired StockService ser;
    @PostMapping("/Post_Stock")
    public Stock create_Stock(@RequestBody Stock stock){
        return ser.createStock(stock);
    }
    @PutMapping("/Put_stock/{id}")
    public Stock update_Stock(@PathVariable Long id,@RequestBody Stock model){
        return ser.updateStock(id,model);
    }
    @GetMapping("/get_Stock/{id}")
    public Stock get_StockById(@PathVariable Long id){
        return ser.getStockById(id);
    }
    @GetMapping("/getall_Stock/user/{userId}")
    public List<Stock> get_AllStocks(){
        return ser.getAllStocks();
    }
    @DeleteMapping("/deleteStock/{id}")
    public String deactivate_Stock(@PathVariable Long id){
        return ser.deactivateStock(id);

    }

}
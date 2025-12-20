
package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RiskThresholdController
{
    @Autowired RiskThresholdService ser;
    @PostMapping("/Post_RiskThreshold")
    public RiskThreshold create_Stock(@RequestBody RiskThreshold stock){
        return ser.createStock(stock);
    }
    @PutMapping("/Put_RiskThreshold/{id}")
    public RiskThreshold update_Stock(@PathVariable Long id,@RequestBody RiskThreshold model){
        return ser.updateStock(id,model);
    }
    @GetMapping("/getid_RiskThreshold/{id}")
    public RiskThreshold get_StockById(@PathVariable Long id){
        return ser.getStockById(id);
    }
    @GetMapping("/getall_RiskThresholdk/user/{userId}")
    public List<RiskThreshold> get_AllStocks(){
        return ser.getAllStocks();
    }
    

}
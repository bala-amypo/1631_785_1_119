// package com.example.demo.controller;
// public class PortfolioHoldingController{
    
// }
package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PortfolioHoldingController
{
    private final PortfolioHoldingService ser;
    
    public PortfolioHoldingController(PortfolioHoldingService ser) {
        this.ser = ser;
    }
    @PostMapping("/Post_PortfolioHolding")
    public UserPortfolio create_Holding(@RequestBody PortfolioHolding Holding){
        return ser.createHolding(Holding);
    }
    @PutMapping("/Put_PortfolioHolding/{id}")
    public UserPortfolio update_Holding(@PathVariable Long id,@RequestBody PortfolioHolding model){
        return ser. updateHolding(id,model);
    }
    @GetMapping("/getid_PortfolioHolding/{id}")
    public UserPortfolio get_HoldingById(@PathVariable Long id){
        return ser.getHoldingById(id);
    }
    @GetMapping("/getall_PortfolioHolding/portfolio/{portfolioId}")
    public List<UserPortfolio> get_HoldingsByPortfolio(){
        return ser.getHoldingsByPortfolio();
    }
    @DeleteMapping("/delete_PortfolioHolding/{id}")
    public String delete_Holding(@PathVariable Long id){
        return ser.deleteHolding(id);

    }

}
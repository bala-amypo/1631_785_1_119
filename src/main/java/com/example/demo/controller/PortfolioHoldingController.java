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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserPortfolioController
{
    @Autowired UserPortfolioService ser;
    @PostMapping("/Post_UserPortfolio")
    public UserPortfolio create_Portfolio(@RequestBody UserPortfolio portfolio){
        return ser.createPortfolio(portfolio);
    }
    @PutMapping("/Put_UserPortfolio_/{id}")
    public UserPortfolio update_Portfolio(@PathVariable Long id,@RequestBody UserPortfolio model){
        return ser.updatePortfolio(id,model);
    }
    @GetMapping("/getid_UserPortfolio/{id}")
    public UserPortfolio get_PortfolioById(@PathVariable Long id){
        return ser.getPortfolioById(id);
    }
    @GetMapping("/getall_UserPortfolio/user/{userId}")
    public List<UserPortfolio> get_PortfoliosByUser(){
        return ser.getPortfoliosByUser();
    }
    @DeleteMapping("/delete_UserPortfolio/{id}")
    public String deactivate_Portfolio(@PathVariable Long id){
        return ser.deactivatePortfolio(id);

    }

}
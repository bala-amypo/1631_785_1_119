// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.demo.model.Stock;
// import com.example.demo.service.StockService;
// import org.springframework.web.bind.annotation.PathVariable;

// @RestController
// public class StockController
// {
//     @Autowired StockService ser;
//     @PostMapping("/Post_Stock")
//     public Stock create_Portfolio(@RequestBody Stock stock){
//         return ser.createStock(stock);
//     }
//     @PutMapping("/Put_stock/{id}")
//     public Stock update_Portfolio(@PathVariable Long id,@RequestBody Stock model){
//         return ser.updateStock(id,model);
//     }
//     @GetMapping("/getid1/{id}")
//     public UserPortfolio get_PortfolioById(@PathVariable Long id){
//         return ser.getPortfolioById(id);
//     }
//     @GetMapping("/get1/user/{userId}")
//     public List<UserPortfolio> get_PortfoliosByUser(){
//         return ser.getPortfoliosByUser();
//     }
//     @DeleteMapping("/delete1/{id}")
//     public String deactivate_Portfolio(@PathVariable Long id){
//         return ser.deactivatePortfolio(id);

//     }

// }
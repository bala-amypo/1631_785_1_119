package com.example.demo.controller;
public class UserPortfolioController{
    @Autowired StudentService ser;
    @PostMapping("/post")
    public StudentEntity senddata(@RequestBody StudentEntity stu){
        return ser.postData(stu);
    }

}
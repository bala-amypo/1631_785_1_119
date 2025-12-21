
package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
     private final RiskThresholdService ser;
    
    public RiskThresholdController(RiskThresholdService ser) {
        this.ser = ser;
    }
    @PostMapping("/Post_RiskThreshold")
    public RiskThreshold create_Threshold(@RequestBody RiskThreshold threshold){
        return ser.createThreshold(threshold);
    }
    @PutMapping("/Put_RiskThreshold/{id}")
    public RiskThreshold update_Threshold(@PathVariable Long id,@RequestBody RiskThreshold model){
        return ser.updateThreshold(id,model);
    }
    @GetMapping("/active")
    public List<RiskThreshold> get_ActiveThreshold(){
        return ser.getActiveThreshold();
    }
    @GetMapping("/getid_RiskThreshold/{id}")
    public RiskThreshold get_ThresholdById(@PathVariable Long id){
        return ser.getThresholdById(id);
    }
    @GetMapping("/getall_RiskThreshold")
    public List<RiskThreshold>get_AllThresholds(){
        return ser.getAllThresholds();
    }
    

}
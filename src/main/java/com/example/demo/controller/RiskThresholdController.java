// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;
// import org.springframework.http.ResponseEntity;
// import com.example.demo.model.RiskThreshold;
// import com.example.demo.service.RiskThresholdService;
// @RestController
// @RequestMapping("/api/risk-thresholds")
// public class RiskThresholdController {

//     private final RiskThresholdService thresholdService;

//     public RiskThresholdController(RiskThresholdService thresholdService) {
//         this.thresholdService = thresholdService;
//     }

//     @PostMapping
//     public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
//         return ResponseEntity.ok(thresholdService.createThreshold(threshold));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable Long id,@RequestBody RiskThreshold threshold) {
//         return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
//         return ResponseEntity.ok(thresholdService.getThresholdById(id));
//     }

//     @GetMapping("/active")
//     public ResponseEntity<List<RiskThreshold>> getActiveThresholds() {
//         return ResponseEntity.ok(thresholdService.getActiveThreshold());
//     }

//     @GetMapping
//     public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
//         return ResponseEntity.ok(thresholdService.getAllThresholds());
//     }
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        RiskThreshold result = thresholdService.createThreshold(threshold);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable Long id, @RequestBody RiskThreshold threshold) {
        RiskThreshold updated = thresholdService.updateThreshold(id, threshold);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
        RiskThreshold result = thresholdService.getThresholdById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/active")
    public ResponseEntity<List<RiskThreshold>> getActiveThresholds() {
        List<RiskThreshold> activeThresholds = thresholdService.getActiveThreshold();
        return ResponseEntity.ok(activeThresholds);
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        List<RiskThreshold> allThresholds = thresholdService.getAllThresholds();
        return ResponseEntity.ok(allThresholds);
    }
}


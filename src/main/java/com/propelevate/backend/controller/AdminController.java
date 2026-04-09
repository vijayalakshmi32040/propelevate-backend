package com.propelevate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.propelevate.backend.entity.Property;
import com.propelevate.backend.entity.Estimate;
import com.propelevate.backend.service.PropertyService;
import com.propelevate.backend.service.EstimateService;
import com.propelevate.backend.dto.EstimateRequest;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private EstimateService estimateService;

    // View All Submissions
    @GetMapping("/submissions")
    public List<Property> getAllSubmissions() {

        return propertyService.getAllProperties();
    }

    // Approve / Reject Property
    @PutMapping("/update-status/{id}")
    public Property updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return propertyService
                .updateStatus(id, status);
    }

    // Add Estimate
    @PostMapping("/add-estimate")
    public Estimate addEstimate(
            @RequestBody EstimateRequest request) {

        Estimate estimate = new Estimate();

        estimate.setPropertyId(
                request.getPropertyId());

        estimate.setTotalCost(
                request.getTotalCost());

        estimate.setValueIncreasePercent(
                request.getValueIncreasePercent());

        estimate.setEstimatedNewValue(
                request.getEstimatedNewValue());

        estimate.setAdminNotes(
                request.getAdminNotes());

        return estimateService
                .saveEstimate(estimate);
    }

}
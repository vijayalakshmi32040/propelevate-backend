package com.propelevate.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.propelevate.backend.dto.EstimateRequest;
import com.propelevate.backend.entity.Estimate;
import com.propelevate.backend.service.EstimateService;
import com.propelevate.backend.service.PropertyService;

@RestController
@RequestMapping("/api/estimate")
@CrossOrigin("*")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @Autowired
    private PropertyService propertyService;

    // Save Estimate and update property status to ESTIMATED
    @PostMapping("/save")
    public ResponseEntity<Estimate> saveEstimate(@RequestBody EstimateRequest request) {
        // Build Estimate entity from request
        Estimate estimate = new Estimate();
        estimate.setPropertyId(request.getPropertyId());
        estimate.setTotalCost(request.getTotalCost());
        estimate.setValueIncreasePercent(request.getValueIncreasePercent());
        estimate.setEstimatedNewValue(request.getEstimatedNewValue());
        estimate.setAdminNotes(request.getAdminNotes());
        estimate.setImprovementCosts(request.getImprovementCosts());

        // Save estimate
        Estimate saved = estimateService.saveEstimate(estimate);

        // Update property status to ESTIMATED
        try {
            propertyService.updateStatus(request.getPropertyId(), "ESTIMATED");
        } catch (Exception e) {
            // Log but don't fail — estimate is already saved
            System.err.println("Warning: Could not update property status: " + e.getMessage());
        }

        return ResponseEntity.ok(saved);
    }

    // Get Estimate by Property ID
    @GetMapping("/property/{propertyId}")
    public Optional<Estimate> getEstimate(@PathVariable Long propertyId) {
        return estimateService.getEstimate(propertyId);
    }

}
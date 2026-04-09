package com.propelevate.backend.dto;

public class EstimateRequest {

    private Long propertyId;

    private String totalCost;

    private String valueIncreasePercent;

    private String estimatedNewValue;

    private String adminNotes;

    private String improvementCosts;

    // Constructor
    public EstimateRequest() {
    }

    // Getters & Setters

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getValueIncreasePercent() {
        return valueIncreasePercent;
    }

    public void setValueIncreasePercent(String valueIncreasePercent) {
        this.valueIncreasePercent = valueIncreasePercent;
    }

    public String getEstimatedNewValue() {
        return estimatedNewValue;
    }

    public void setEstimatedNewValue(String estimatedNewValue) {
        this.estimatedNewValue = estimatedNewValue;
    }

    public String getAdminNotes() {
        return adminNotes;
    }

    public void setAdminNotes(String adminNotes) {
        this.adminNotes = adminNotes;
    }

    public String getImprovementCosts() {
        return improvementCosts;
    }

    public void setImprovementCosts(String improvementCosts) {
        this.improvementCosts = improvementCosts;
    }
}
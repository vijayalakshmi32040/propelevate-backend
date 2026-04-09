package com.propelevate.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estimates")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long propertyId;

    private String totalCost;

    private String valueIncreasePercent;

    private String estimatedNewValue;

    private String adminNotes;

    @Column(length = 2000)
    private String improvementCosts;

    // Constructors

    public Estimate() {
    }

    public Estimate(Long id,
                    Long propertyId,
                    String totalCost,
                    String valueIncreasePercent,
                    String estimatedNewValue,
                    String adminNotes,
                    String improvementCosts) {

        this.id = id;
        this.propertyId = propertyId;
        this.totalCost = totalCost;
        this.valueIncreasePercent = valueIncreasePercent;
        this.estimatedNewValue = estimatedNewValue;
        this.adminNotes = adminNotes;
        this.improvementCosts = improvementCosts;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
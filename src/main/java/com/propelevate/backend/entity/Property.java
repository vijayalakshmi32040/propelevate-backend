package com.propelevate.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyType;

    private String propertyValue;

    private String propertyAge;

    private String builtUpArea;

    private String street;

    private String city;

    private String state;

    private String pinCode;

    private String locality;

    @Column(length = 1000)
    private String notes;

    private String status;

    private String improvements;

    private String ownerName;

    private String ownerEmail;

    private Long ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Estimate> estimates;

    // Constructors

    public Property() {
    }

    public Property(Long id, String propertyType,
                    String propertyValue,
                    String propertyAge,
                    String builtUpArea,
                    String street,
                    String city,
                    String state,
                    String pinCode,
                    String locality,
                    String notes,
                    String status,
                    String improvements,
                    String ownerName,
                    String ownerEmail,
                    Long ownerId) {

        this.id = id;
        this.propertyType = propertyType;
        this.propertyValue = propertyValue;
        this.propertyAge = propertyAge;
        this.builtUpArea = builtUpArea;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.locality = locality;
        this.notes = notes;
        this.status = status;
        this.improvements = improvements;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerId = ownerId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(String propertyAge) {
        this.propertyAge = propertyAge;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(String builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImprovements() {
        return improvements;
    }

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Estimate> getEstimates() {
        return estimates;
    }

    public void setEstimates(List<Estimate> estimates) {
        this.estimates = estimates;
    }
}
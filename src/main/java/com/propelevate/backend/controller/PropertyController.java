package com.propelevate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.propelevate.backend.entity.Property;
import com.propelevate.backend.service.PropertyService;

@RestController
@RequestMapping("/api/property")
@CrossOrigin("*")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Add Property
    @PostMapping("/add")
    public Property addProperty(
            @RequestBody Property property) {

        return propertyService.addProperty(property);
    }

    // Get All Properties
    @GetMapping("/all")
    public List<Property> getAllProperties() {

        return propertyService.getAllProperties();
    }

    // Get User Properties
    @GetMapping("/user/{ownerId}")
    public List<Property> getUserProperties(
            @PathVariable Long ownerId) {

        return propertyService
                .getUserProperties(ownerId);
    }

    // Delete Property
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(
            @PathVariable Long id) {

        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }

}
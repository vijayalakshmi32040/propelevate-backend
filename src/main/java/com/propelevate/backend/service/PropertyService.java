package com.propelevate.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.propelevate.backend.entity.Property;
import com.propelevate.backend.repository.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // Save Property
    public Property addProperty(Property property) {

        property.setStatus("PENDING");

        return propertyRepository.save(property);
    }

    // Get All Properties
    public List<Property> getAllProperties() {

        return propertyRepository.findAll();
    }

    // Get Properties By User
    public List<Property> getUserProperties(Long ownerId) {

        return propertyRepository.findByOwnerId(ownerId);
    }

    // Update Status
    public Property updateStatus(Long id, String status) {

        Property property =
                propertyRepository.findById(id).get();

        property.setStatus(status);

        return propertyRepository.save(property);
    }

    // Delete Property
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

}
package com.propelevate.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.propelevate.backend.entity.Estimate;
import com.propelevate.backend.repository.EstimateRepository;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    // Save Estimate
    public Estimate saveEstimate(Estimate estimate) {

        return estimateRepository.save(estimate);
    }

    // Get Estimate By Property
    public Optional<Estimate> getEstimate(Long propertyId) {

        return estimateRepository
                .findByPropertyId(propertyId);
    }

}
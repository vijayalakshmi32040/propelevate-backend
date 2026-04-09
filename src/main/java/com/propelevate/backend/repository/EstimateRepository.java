package com.propelevate.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.propelevate.backend.entity.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {

    Optional<Estimate> findByPropertyId(Long propertyId);

}
package com.propelevate.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.propelevate.backend.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByOwnerId(Long ownerId);

}
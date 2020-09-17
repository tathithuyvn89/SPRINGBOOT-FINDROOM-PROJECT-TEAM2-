package com.codegym.vn.repositories;

import com.codegym.vn.models.house.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    Boolean existsFeatureByName(String name);
}

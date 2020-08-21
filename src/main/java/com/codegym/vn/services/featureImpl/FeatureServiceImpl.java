package com.codegym.vn.services.featureImpl;

import com.codegym.vn.models.Feature;
import com.codegym.vn.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;
    @Override
    public Feature findById(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    @Override
    public Feature remove(Long id) {
        Feature feature = this.findById(id);
        featureRepository.deleteById(id);
        return feature;
    }

    @Override
    public Feature save(Feature model) {
        return featureRepository.save(model);
    }
}

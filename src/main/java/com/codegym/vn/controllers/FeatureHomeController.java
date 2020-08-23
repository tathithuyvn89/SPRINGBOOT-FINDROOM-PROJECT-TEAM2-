package com.codegym.vn.controllers;

import com.codegym.vn.models.Feature;
import com.codegym.vn.services.featureImpl.FeatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/featurehomes")
public class FeatureHomeController {
    @Autowired
    private FeatureServiceImpl featureService;

    @PostMapping()
    public ResponseEntity<?> createNewFeature(@RequestBody Feature feature) {
        String name = feature.getName();
        if (featureService.existsFeatureByName(name)){
            return new ResponseEntity<String>("Name Category empty or exist", HttpStatus.BAD_REQUEST);

        } else {
            Feature newFeature = featureService.save(feature);
            return new ResponseEntity<Feature>(newFeature, HttpStatus.OK);
        }
    }
    @GetMapping
    public ResponseEntity<List<Feature>> showListFeatures(){
        List<Feature> features = featureService.findAll();
        if ( features.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(features, HttpStatus.OK);
        }
    }

}

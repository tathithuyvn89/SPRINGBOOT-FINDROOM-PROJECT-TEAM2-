package com.codegym.vn.controllers;

import com.codegym.vn.models.District;
import com.codegym.vn.services.districtImpl.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping()
    public ResponseEntity<List<District>> showAllDistrict(){
        List<District> districts = districtService.findAll();
        if (districts.size() ==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<District> showProvinceById(@PathVariable Long id) {
         District district = districtService.findById(id);
        if (district ==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(district, HttpStatus.OK);
    }


    }


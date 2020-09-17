package com.codegym.vn.controllers;

import com.codegym.vn.models.house.Province;
import com.codegym.vn.services.provinceImpl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping()
    public ResponseEntity<List<Province>> showAllProvince() {
        List<Province> provinces = provinceService.findAll();
        if (provinces.size() ==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<Province> showProvinceById(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        if (province ==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(province, HttpStatus.OK);
    }
}

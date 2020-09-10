package com.codegym.vn.controllers;

import com.codegym.vn.models.HouseAddress;
import com.codegym.vn.services.houseaddress.HouseAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.Address;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/address")
public class HouseAddressController {

    @Autowired
    private HouseAddressService houseAddressService;

    @PostMapping()
    public ResponseEntity<HouseAddress> saveHouseAddress(@RequestBody HouseAddress houseAddress){
        if (houseAddress ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        HouseAddress houseAddress1 = houseAddressService.save(houseAddress);
        if (houseAddress1==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<HouseAddress>(houseAddress1, HttpStatus.OK);
        }
    }
}

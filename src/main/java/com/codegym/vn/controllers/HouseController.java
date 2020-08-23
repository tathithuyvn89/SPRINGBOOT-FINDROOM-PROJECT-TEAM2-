package com.codegym.vn.controllers;

import com.codegym.vn.models.House;
import com.codegym.vn.models.Image;
import com.codegym.vn.services.houseServiceImpl.HouseServiceImpl;
import com.codegym.vn.services.imageServiceImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/houses")
  public class HouseController {

  @Autowired
  private HouseServiceImpl houseService;

  @Autowired
  private ImageServiceImpl imageService;
  @PostMapping
  public ResponseEntity<House> createNewHouse(@RequestBody House  house) {
    House newHouse = new House();
    newHouse.setNameHouse(house.getNameHouse());
    newHouse.setAddress(house.getAddress());
    newHouse.setBedroomNum(house.getBedroomNum());
    newHouse.setBathroomNum(house.getBathroomNum());
    newHouse.setDescription(house.getDescription());
    newHouse.setPriceOneDay(house.getPriceOneDay());
//    newHouse.setStatus(house.getStatus());
    newHouse.setCategoryHome(house.getCategoryHome());
//    newHouse.setFeatures(house.getFeatures());
    //Sau khi tim duoc user_id cua nguoi dang se tien hang luu house vao db
    House reponse = houseService.save(newHouse);
    List<Image> images = house.getImages();
    for (Image image: images) {
      image.setHouse(reponse);
      imageService.save(image);
    }
    return new ResponseEntity<>(reponse, HttpStatus.OK);
  }
}
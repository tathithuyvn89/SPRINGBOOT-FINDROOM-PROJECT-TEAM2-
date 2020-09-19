package com.codegym.vn.controllers;

import com.codegym.vn.models.house.House;
import com.codegym.vn.models.house.Image;
import com.codegym.vn.services.houseServiceImpl.HouseService;
import com.codegym.vn.services.imageServiceImpl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/houses")
  public class HouseController {
  @Autowired
  private HouseService houseService;

  @Autowired
  private ImageService imageService;
  @PostMapping
  public ResponseEntity<House> createNewHouse(@RequestBody House  house) {

    House newHouse = new House();
    newHouse.setHouseAddress(house.getHouseAddress());
    newHouse.setNameHouse(house.getNameHouse());
    newHouse.setBedroomNum(house.getBedroomNum());
    newHouse.setBathroomNum(house.getBathroomNum());
    newHouse.setDescription(house.getDescription());
    newHouse.setPriceOneDay(house.getPriceOneDay());
    newHouse.setCategoryHome(house.getCategoryHome());
    newHouse.setFeatures(house.getFeatures());

    //Sau khi tim duoc user_id cua nguoi dang se tien hang luu house vao db
    House reponse = houseService.save(newHouse);
    List<Image> images = house.getImages();
    for (Image image: images) {
      image.setHouse(reponse);
      imageService.save(image);
    }
    return new ResponseEntity<>(reponse, HttpStatus.OK);
  }
  @GetMapping()
  public ResponseEntity<List<House>> showListHouses(){
    List<House> houses = houseService.findAll();
    if (houses==null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(houses, HttpStatus.OK);
    }
  }
  @GetMapping("/details/{id}")
  public ResponseEntity<House> detailsOneHouseById(@PathVariable Long id) {
    House house = houseService.findById(id);
    if (house ==null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(house, HttpStatus.OK);
    }
  }


}
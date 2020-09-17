package com.codegym.vn.controllers;

import com.codegym.vn.models.house.Image;
import com.codegym.vn.services.imageServiceImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/images")
  public class ImageController {

  @Autowired
  private ImageServiceImpl imageService;

  @PostMapping()
  public ResponseEntity<Image> createNewImage(@RequestBody Image image){
   Image newImage = imageService.save(image);
    return new ResponseEntity<>(newImage, HttpStatus.OK);
  }
}
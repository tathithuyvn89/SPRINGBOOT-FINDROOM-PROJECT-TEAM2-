package com.codegym.vn.controllers;

import com.codegym.vn.models.house.CategoryHome;
import com.codegym.vn.services.categoryHouseServiceImpl.CategoryHomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/categoryhomes")
public class CategoryHomeController {

    @Autowired
    private CategoryHomeServiceImpl categoryHomeService;

    @PostMapping
    public ResponseEntity<?> createNewCategoryHome
            (@RequestBody CategoryHome categoryHome) {
     String name = categoryHome.getNameCategoryHome();
     //Chua xu ly duoc loi neu exception xay ra
        if (name.isEmpty()||categoryHomeService.existsCategoryHomesByNameCategoryHome(name)){
            return new ResponseEntity<String>("Create not success",HttpStatus.NO_CONTENT);
        } else {
            CategoryHome respon = categoryHomeService.save(categoryHome);
            return new ResponseEntity<CategoryHome>(respon,HttpStatus.OK);
        }
    }
    @GetMapping()
    public ResponseEntity<List<CategoryHome>> showListCategoryHome() {
        List<CategoryHome> categoryHomes = categoryHomeService.findAll();
        if (categoryHomes.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(categoryHomes, HttpStatus.OK);
        }
    }
}

package com.codegym.vn.controller;

import com.codegym.vn.services.houseServiceImpl.HouseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HouseController {

    Mockito mockito;


    @InjectMocks
    private HouseController houseController;
    @InjectMocks
    private HouseService houseService;

    @BeforeEach
    public void init(){
        houseService = Mockito.mock(HouseService.class);
    }



}

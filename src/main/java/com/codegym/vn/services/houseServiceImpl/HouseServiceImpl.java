package com.codegym.vn.services.houseServiceImpl;

import com.codegym.vn.models.House;
import com.codegym.vn.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseRepository houseRepository;
    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public House remove(Long id) {
        House house = houseRepository.findById(id).orElse(null);
        houseRepository.deleteById(id);
        return house;
    }

    @Override
    public House save(House model) {
        return  houseRepository.save(model);
    }
}
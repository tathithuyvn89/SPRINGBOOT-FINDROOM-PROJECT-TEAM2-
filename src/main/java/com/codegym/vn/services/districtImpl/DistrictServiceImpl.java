package com.codegym.vn.services.districtImpl;

import com.codegym.vn.models.District;
import com.codegym.vn.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;


    @Override
    public District findById(Long id) {
        return districtRepository.findById(id).orElse(null);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District remove(Long id) {
        return null;
    }

    @Override
    public District save(District model) {
        return null;
    }
}

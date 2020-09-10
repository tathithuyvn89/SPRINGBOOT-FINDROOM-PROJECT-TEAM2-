package com.codegym.vn.services.houseaddress;

import com.codegym.vn.models.HouseAddress;
import com.codegym.vn.repositories.HouseAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseAddressServiceImpl implements HouseAddressService {

    @Autowired
    private HouseAddressRepository houseAddressRepository;

    @Override
    public HouseAddress save(HouseAddress model) {
        return houseAddressRepository.save(model);
    }
    @Override
    public HouseAddress findById(Long id) {
        return null;
    }

    @Override
    public List<HouseAddress> findAll() {
        return null;
    }

    @Override
    public HouseAddress remove(Long id) {
        return null;
    }

}

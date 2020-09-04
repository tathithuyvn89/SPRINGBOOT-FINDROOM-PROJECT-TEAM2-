package com.codegym.vn.services.provinceImpl;

import com.codegym.vn.models.Province;
import com.codegym.vn.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province remove(Long id) {
        return null;
    }

    @Override
    public Province save(Province model) {
        return null;
    }
}

package com.codegym.vn.services.imageServiceImpl;

import com.codegym.vn.models.house.Image;
import com.codegym.vn.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image remove(Long id) {
        Image image = imageRepository.findById(id).orElse(null);
         imageRepository.deleteById(id);
         return image;
    }

    @Override
    public Image save(Image model) {
        return imageRepository.save(model);
    }
}
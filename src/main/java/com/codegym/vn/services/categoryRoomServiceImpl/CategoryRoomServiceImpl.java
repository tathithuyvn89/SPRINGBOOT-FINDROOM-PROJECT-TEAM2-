package com.codegym.vn.services.categoryRoomServiceImpl;

import com.codegym.vn.models.CategoryRoom;
import com.codegym.vn.repositories.CategoryRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class CategoryRoomServiceImpl  implements CategoryRoomService{

    @Autowired
    private CategoryRoomRepository categoryRoomRepository;


    @Override
    public CategoryRoom findById(Long id) {
        return categoryRoomRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryRoom> findAll() {
        return categoryRoomRepository.findAll();
    }

    @Override
    public CategoryRoom remove(Long id) {
        CategoryRoom categoryRoom = this.findById(id);
         categoryRoomRepository.deleteById(id);
        return categoryRoom;
    }

    @Override
    public CategoryRoom save(CategoryRoom model) {
        return categoryRoomRepository.save(model);
    }
}
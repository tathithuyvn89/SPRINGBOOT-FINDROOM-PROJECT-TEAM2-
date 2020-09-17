package com.codegym.vn.services.categoryHouseServiceImpl;

import com.codegym.vn.models.house.CategoryHome;
import com.codegym.vn.repositories.CategoryHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class CategoryHomeServiceImpl implements CategoryHouseService{

    @Autowired
    private CategoryHomeRepository categoryHomeRepository;


    @Override
    public CategoryHome findById(Long id) {
        return categoryHomeRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryHome> findAll() {
        return categoryHomeRepository.findAll();
    }

    @Override
    public CategoryHome remove(Long id) {
        CategoryHome categoryHome = this.findById(id);
        categoryHomeRepository.deleteById(id);
        return categoryHome;
    }

    @Override
    public CategoryHome save(CategoryHome model) {

        return categoryHomeRepository.save(model);
    }

    @Override
    public Boolean existsCategoryHomesByNameCategoryHome(String name) {
        return categoryHomeRepository.existsCategoryHomesByNameCategoryHome(name);
    }
}
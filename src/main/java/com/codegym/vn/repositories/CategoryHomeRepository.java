package com.codegym.vn.repositories;

import com.codegym.vn.models.CategoryHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface CategoryHomeRepository extends JpaRepository<CategoryHome, Long> { }
package com.codegym.vn.repositories;

import com.codegym.vn.models.CategoryRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRoomRepository extends JpaRepository<CategoryRoom, Long> {
}

package com.codegym.vn.repositories;

import com.codegym.vn.models.house.HouseAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseAddressRepository extends JpaRepository<HouseAddress, Long> {

}

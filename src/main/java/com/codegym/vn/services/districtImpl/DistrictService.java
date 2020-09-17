package com.codegym.vn.services.districtImpl;

import com.codegym.vn.models.house.District;
import com.codegym.vn.services.CrudServiceGeneric;

import java.util.List;

public interface DistrictService extends CrudServiceGeneric<District> {
    List<District> findAllByProvinceProvinceName(String provinceName);
}

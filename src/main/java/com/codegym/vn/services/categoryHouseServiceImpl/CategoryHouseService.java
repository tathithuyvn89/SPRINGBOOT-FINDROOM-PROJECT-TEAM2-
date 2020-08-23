package com.codegym.vn.services.categoryHouseServiceImpl;

import com.codegym.vn.models.CategoryHome;
import com.codegym.vn.services.CrudServiceGeneric;

public interface CategoryHouseService extends CrudServiceGeneric<CategoryHome> {
    Boolean existsCategoryHomesByNameCategoryHome(String name);
}

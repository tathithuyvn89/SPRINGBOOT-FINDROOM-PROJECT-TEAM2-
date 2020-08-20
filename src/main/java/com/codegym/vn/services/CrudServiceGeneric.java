package com.codegym.vn.services;

import java.util.List;

public interface CrudServiceGeneric<T> {

    T findById (Long id);

    List<T> findAll();

    T remove (Long id);

    T save(T model);

}

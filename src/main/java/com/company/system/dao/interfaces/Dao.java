package com.company.system.dao.interfaces;

import java.util.List;

public interface Dao <T>{
    boolean create(T object);

    List<T> findAll();

    T findById(Long id);

    boolean update(T object);

    boolean deleteByID(Long id);
}

package com.company.system.dao.interfaces;

import java.util.List;

public interface Dao <T>{
    boolean create(T object);

    List<T> findAll();

    List<T> findAllIncludeDeleted();

    T findById(Long id);
    
    T findByIdIncludeDeleted(Long id);

    boolean update(T object);

    boolean deleteByID(Long id);
}

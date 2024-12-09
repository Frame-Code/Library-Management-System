package com.company.system.dao.interfaces;

import com.company.system.model.Category;

public interface CategoryDAO extends Dao<Category>{
    Category findByName(String name);
}

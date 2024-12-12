package com.company.system.dao.interfaces;

import com.company.system.model.Category;

public interface CategoryDao extends Dao<Category>{
    Category findByName(String name);
}

package com.company.system.service;
/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */

import java.util.List;

import com.company.system.dao.impl.CategoryDaoImpl;
import com.company.system.dao.interfaces.CategoryDAO;
import com.company.system.model.Category;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDaoImpl();
    }

    public List<Category> getCategories() {
        return categoryDAO.findAll();
    }

    public Category getCategoryByName(String name) {
        return categoryDAO.findByName(name);
    }

}

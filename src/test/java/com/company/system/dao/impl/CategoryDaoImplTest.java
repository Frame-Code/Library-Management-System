package com.company.system.dao.impl;

import java.util.List;
import com.company.system.model.Category;

import org.junit.jupiter.api.Test;

public class CategoryDaoImplTest {
    @Test
    void testFindAll() {
        CategoryDaoImpl categoryDAO = new CategoryDaoImpl();
        List<Category> categories = categoryDAO.findAll();
        categories.forEach(category -> {
            System.out.println(category.getName());
        });
    }

    @Test
    void testFindByName() {
        CategoryDaoImpl categoryDAO = new CategoryDaoImpl();
        Category category = categoryDAO.findByName(Category.categoryMathematics);
        System.out.println(category);
    }
}

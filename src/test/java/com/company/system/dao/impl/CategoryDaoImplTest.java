package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import com.company.system.dao.interfaces.CategoryDAO;
import com.company.system.model.Category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryDaoImplTest {
    CategoryDAO categoryDAO;
    @BeforeEach
    void setUp() {
        this.categoryDAO = new CategoryDaoImpl();
    }

    @Test
    void testCreate() {
        Category category = new Category(Category.categoryArchitecture, LocalDate.now(), 
            "Admin", null, null, false);
        System.out.println(categoryDAO.create(category));
    }

    @Test
    void testDeleteByID() {
        System.out.println(categoryDAO.deleteByID(1L));
    }

    @Test
    void testFindAll() {
        List<Category> categories = categoryDAO.findAll();
        categories.forEach(category -> {
            System.out.println(category);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Category> categories = categoryDAO.findAllIncludeDeleted();
        categories.forEach(category -> {
            System.out.println(category);
        }); 
    }

    @Test
    void testFindById() {
        Category category = categoryDAO.findById(1L);
        Category category1 = categoryDAO.findById(2L);
        System.out.println(category);
        System.out.println(category1);
    }

    @Test
    void testFindByName() {
        Category category = categoryDAO.findByName(Category.categoryMathematics);
        Category category1 = categoryDAO.findByName(Category.categoryAI);
        System.out.println(category);
        System.out.println(category1);
    }

    @Test
    void testUpdate() {
        Category category = categoryDAO.findByIdIncludeDeleted(1L);
        category.setDeleted(false);
        System.out.println(categoryDAO.update(category));
    }
}

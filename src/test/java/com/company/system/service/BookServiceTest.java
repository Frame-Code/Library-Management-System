package com.company.system.service;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.company.system.dao.impl.CategoryDaoImpl;
import com.company.system.model.Book;
import com.company.system.model.Category;

public class BookServiceTest {
    @Test
    void testGetBooksByCategory() {
        BookService bookService = new BookService();
        List<Book> books = bookService.getBooksByCategory(new CategoryDaoImpl().findByName(Category.categoryMathematics));
        books.forEach(book -> {
            System.out.println(book);
        });
    }
}

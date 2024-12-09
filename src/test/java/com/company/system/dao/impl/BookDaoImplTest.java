package com.company.system.dao.impl;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.company.system.model.Book;
import com.company.system.model.Category;

public class BookDaoImplTest {
    @Test
    void testFindByCategory() {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findByCategory(new CategoryDaoImpl().findByName(Category.categoryAI));
        books.forEach(book -> {
            System.out.println(book);
        });
    }
}

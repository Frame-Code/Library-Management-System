package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Book;
import com.company.system.model.Category;

public class BookDaoImplTest {
    BookDao bookDao;
    @BeforeEach
    void setUp() {
        this.bookDao = new BookDaoImpl();
    }

    @Test
    void testFindByCategory() {
        List<Book> books = bookDao.findByCategory(new CategoryDaoImpl().findByName(Category.categoryAI));
        books.forEach(book -> {
            System.out.println(book);
        });
    }

    @Test
    void testFindByISBN() {
        Book book = bookDao.findByISBN("JPKL-1");
        System.out.println(book);
    }

    @Test
    void testCreate() {
        Book book = new Book("JPKL-5", "La sociedad del cansancio", "Un libro que trata sobre como las generaciones actuales se autoexplotan por la compotencia",
         LocalDate.now(), 4, null, new CategoryDaoImpl().findByName(Category.categoryAI), null, 
         LocalDate.now(), "Admin", null, null, false);
        System.out.println(bookDao.create(book));
    }

    @Test
    void testDeleteByID() {
        System.out.println(bookDao.deleteByID(7L));
    }

    @Test
    void testFindAll() {
        List<Book> books = bookDao.findAll();
        books.forEach(book -> {
            System.out.println(book);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Book> books = bookDao.findAllIncludeDeleted();
        books.forEach(book -> {
            System.out.println(book);
        });
    }

    @Test
    void testFindById() {
        Book book = bookDao.findById(4L);
        //Book book1 = bookDao.findById(7L);
        //System.out.println(book.getAuthors());
        book.getAuthors().forEach(author -> {
            System.out.println(author);
        });
        //System.out.println(book1);
    }

    @Test
    void testFindByIdIncludeDeleted() {
        Book book = bookDao.findByIdIncludeDeleted(3L);
        Book book1 = bookDao.findByIdIncludeDeleted(7L);
        System.out.println(book);
        System.out.println(book1);
    }

    @Test
    void testUpdate() {
        Book book = bookDao.findById(5L);
        book.setRegistrationName("Admin");
        System.out.println(bookDao.update(book));
    }

    @Test
    void testFindByPublisher() {
        List<Book> books = bookDao.findByPublisher(new PublisherDaoImpl().findByName("Simon & Schuster"));
        books.forEach(book -> {
           System.out.println(book); 
        });
    }
}

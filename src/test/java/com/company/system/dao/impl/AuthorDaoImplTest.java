package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.AuthorDao;
import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Author;
import com.company.system.model.Book;

public class AuthorDaoImplTest {
    AuthorDao authorDao;
    BookDao bookDao;

    @BeforeEach
    void setUp() {
        this.authorDao = new AuthorDaoImpl();
        this.bookDao = new BookDaoImpl();
    }

    @Test
    void testCreate() {
        List<Book> books = new ArrayList<>();
        books.add(bookDao.findByIdIncludeDeleted(7L));
        books.add(bookDao.findByIdIncludeDeleted(3L));

        Author author = new Author("Julia", "Pluas Cantillo", books,
         LocalDate.now(), "Admin", null, null, false);

        //System.out.println(authorDao.create(author));

        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(24L));

        books.forEach(book -> {
            book.setAuthors(authors);
            System.out.println(bookDao.update(book));
        });

    }

    @Test
    void testDeleteByID() {
        /*Author author = authorDao.findByIdIncludeDeleted(24L);
        if(author.getBooks().isEmpty()) { //No se pueden eliminar autores con libros registrados pero 
            System.out.println(authorDao.deleteByID(24L));
        }*/
    }

    @Test
    void testFindAll() {
        List<Author> authors = authorDao.findAll();
        authors.forEach(author -> {
            System.out.println(author);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Author> authors = authorDao.findAllIncludeDeleted();
        authors.forEach(author -> {
            System.out.println(author);
        });
    }

    @Test
    void testFindById() { 
        //System.out.println(authorDao.findById(24L));
    }

    @Test
    void testFindByIdIncludeDeleted() {
        //System.out.println(authorDao.findByIdIncludeDeleted(24L));
    }

    @Test
    void testUpdate() {
        /*Author author = authorDao.findByIdIncludeDeleted(24L);
        author.setDeleted(false);
        System.out.println(authorDao.update(author));*/
    }
}

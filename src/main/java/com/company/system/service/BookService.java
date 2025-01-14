package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.BookDaoImpl;
import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Author;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;
import com.company.system.model.User;
import java.time.LocalDate;

public class BookService {
    private BookDao bookDao;

    public BookService() {
        this.bookDao = new BookDaoImpl();
    }
    
    public List<Book> getBooksByCategory(Category category) {
        return bookDao.findByCategory(category);
    }

    public List<Book> getBooksByPublisher(Publisher publisher) {
        return bookDao.findByPublisher(publisher);
    }

    public Book getBookByISBN(String isbn) {
        return bookDao.findByISBN(isbn);
    }
    
    public List<Book> searchBook(String pattern) {
        return bookDao.findByPattern(pattern);
    }

    public boolean isAvailableToLoan(Book book) {
        return book.getStockToLoan() > 0;
    }

    public boolean updateBookStock(Book book) {
        book.setStockToLoan(book.getStockToLoan() - 1);
        return bookDao.update(book);
    }

    public boolean RegisterBook(String isbn, String title, String description, LocalDate yearPublished, 
        Publisher publisher, Category category, List<Author> authors, Integer stock, User librarian) {
        
        Book book = new Book(isbn, title, description, yearPublished, stock,
                stock, publisher, category, authors, LocalDate.now(), 
               librarian.getFullNames(), null, null, false);
        return bookDao.create(book); 
    }  
    
}

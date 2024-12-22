package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.BookDaoImpl;
import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;

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

    public Integer getStockToLoanByBook(Book book) {
        return bookDao.findById(book.getIdBook()).getStockToLoan();
    }

}

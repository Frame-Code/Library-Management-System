package com.company.system.dao.interfaces;

import java.util.List;

import com.company.system.model.Author;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;

public interface BookDao extends Dao<Book>{
    List<Book> findByCategory(Category category);

    List<Book> findByAuthor(Author author);

    List<Book> findByPublisher(Publisher publisher);

    Book findByISBN(String isbn);
}

package com.company.system.dao.interfaces;

import java.util.List;

import com.company.system.model.Book;
import com.company.system.model.Category;

public interface BookDao extends Dao<Book>{
    List<Book> findByCategory(Category category);

    Book findByISBN(String isbn);
}

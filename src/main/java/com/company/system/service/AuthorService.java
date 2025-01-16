
package com.company.system.service;

import com.company.system.dao.impl.AuthorDaoImpl;
import com.company.system.dao.interfaces.AuthorDao;
import com.company.system.model.Author;
import java.util.ArrayList;
import java.util.List;

/**|
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class AuthorService {
    private final AuthorDao authorDao;

    public AuthorService() {
        this.authorDao = new AuthorDaoImpl();
    }
    
    public Author findById(Long id) {
        return authorDao.findById(id);
    }
    
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }
    
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }
    
    public List<Author> getAuthors(List<Long> idAuthors) {
        List<Author> authors = new ArrayList<>();
        idAuthors.forEach(id -> {
            authors.add(findById(id));
        });
        
        return authors;
    }
    
    
    
}

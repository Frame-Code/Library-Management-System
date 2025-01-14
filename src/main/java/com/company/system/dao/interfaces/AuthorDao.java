package com.company.system.dao.interfaces;

import com.company.system.model.Author;
import java.util.List;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public interface AuthorDao extends Dao<Author>{
    List<Author> findByName(String name);
}

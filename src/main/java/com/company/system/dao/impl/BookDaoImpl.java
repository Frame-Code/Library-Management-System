package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Book;
import com.company.system.model.Category;

public class BookDaoImpl implements BookDao{
    private final EntityManagerFactory emf;

    public BookDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    } 

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Book object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Book> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Book findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Book object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public List<Book> findByCategory(Category category) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.category = :cat AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("cat", category);
        List<Book> books;
        try {
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

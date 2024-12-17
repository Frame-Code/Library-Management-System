package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.AuthorDao;
import com.company.system.model.Author;

/**
 *
 * @author Daniel Mora Cantillo
 */
public class AuthorDaoImpl implements AuthorDao{
    private EntityManagerFactory emf;

    public AuthorDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPu");
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    @Override
    public boolean create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List findAllIncludeDeleted() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Author a WHERE a.idAuthor = :id and a.deleted = 0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        query.setParameter("id", id);
        Author author;
        try {
            author = query.getSingleResult();
            return author;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Object findByIdIncludeDeleted(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

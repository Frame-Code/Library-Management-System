package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.CategoryDAO;
import com.company.system.model.Book;
import com.company.system.model.Category;

public class CategoryDaoImpl implements CategoryDAO{
    private EntityManagerFactory emf;

    
   public CategoryDaoImpl() {
    this.emf = Persistence.createEntityManagerFactory("libraryPU");
   }    

   private EntityManager getEntityManager() {
        return emf.createEntityManager();
   }

    @Override
    public boolean create(Category object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


 @Override
    public List<Category> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.deleted=0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        List<Category> categories;
        try {
            categories = query.getResultList();
            return categories;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Category findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Category object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public Category findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.name = :name AND c.deleted=0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("name", name);
        Category category;
        try {
            category = query.getSingleResult();
            return category;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

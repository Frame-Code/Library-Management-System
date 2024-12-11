package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.CategoryDao;
import com.company.system.model.Category;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class CategoryDaoImpl implements CategoryDao{
    private EntityManagerFactory emf;

    
   public CategoryDaoImpl() {
    this.emf = Persistence.createEntityManagerFactory("libraryPU");
   }    

   private EntityManager getEntityManager() {
        return emf.createEntityManager();
   }

    @Override
    public boolean create(Category object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } catch (EntityExistsException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } catch (TransactionRequiredException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
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
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.idCategory = :id and c.deleted = 0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("id", id);
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

    @Override
    public boolean update(Category object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } catch (EntityExistsException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } catch (TransactionRequiredException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        Category category = findById(id); 
        category.setDeleted(true);
        return update(category);
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

    @Override
    public List<Category> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Category c";
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
    public Category findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.idCategory = :id";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("id", id);
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

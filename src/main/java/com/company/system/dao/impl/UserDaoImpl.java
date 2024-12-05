package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */

public class UserDaoImpl implements UserDao{
    private EntityManagerFactory emf;
    
    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("libraryPU");
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public boolean create(User object) {
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
            emf.close();
        }
    }


    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public User findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: no se puede crear ");
        } finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public boolean update(User object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public User findByIdCard(Long idCard) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.idCardUser = :idCard";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("idCard", idCard);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

}

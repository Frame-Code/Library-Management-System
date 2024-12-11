package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.model.Category;
import com.company.system.model.Publisher;

public class PublisherDaoImpl implements PublisherDao{
    private final EntityManagerFactory emf;

    public PublisherDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Publisher object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Publisher> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p WHERE p.deleted=0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        List<Publisher> publishers;
        try {
            publishers = query.getResultList();
            return publishers;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Publisher> findAllIncludeDeleted() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllIncludeDeleted'");
    }

    @Override
    public Publisher findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Publisher findByIdIncludeDeleted(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdIncludeDeleted'");
    }

    @Override
    public boolean update(Publisher object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public Publisher findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p WHERE p.name=:name AND p.deleted=0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        Publisher publisher;
        try {
            publisher = query.getResultList();
            return publisher;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.model.Publisher;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class PublisherDaoImpl implements PublisherDao {

    private final EntityManagerFactory emf;

    public PublisherDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Publisher object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException | EntityExistsException | TransactionRequiredException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
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
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p";
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
    public Publisher findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p WHERE p.idPublisher = :id AND p.deleted = 0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("id", id);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Publisher findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p WHERE p.idPublisher = :id";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("id", id);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public boolean update(Publisher object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException | TransactionRequiredException | IllegalArgumentException | RollbackException e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        Publisher publisher = findById(id);
        publisher.setDeleted(true);
        return update(publisher);
    }

    @Override
    public Publisher findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Publisher p WHERE p.name=:name AND p.deleted=0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("name", name);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

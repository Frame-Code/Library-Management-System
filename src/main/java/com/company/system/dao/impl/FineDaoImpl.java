package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.FineDao;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.model.User;

public class FineDaoImpl implements FineDao {
    private EntityManagerFactory emf;

    public FineDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Fine object) {
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
    public List<Fine> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT f FROM Fine f WHERE f.deleted=0";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Fine> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT f FROM Fine f";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Fine findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT f FROM Fine f WHERE f.idFine = :id AND f.deleted = 0";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        query.setParameter("id", id);
        Fine fine;
        try {
            fine = query.getSingleResult();
            return fine;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Fine findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT f FROM Fine f WHERE f.idLoan = :id";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        query.setParameter("id", id);
        Fine fine;
        try {
            fine = query.getSingleResult();
            return fine;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Fine object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException | TransactionRequiredException | IllegalArgumentException
                | RollbackException e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        Fine fine = findById(id);
        fine.setDeleted(true);
        return update(fine);
    }

    @Override
    public List<Fine> findByUser(User user) {
        EntityManager em = getEntityManager();
        String jpal = "SELECT f FROM Fine f WHERE f.user = :user AND f.deleted=0";
        TypedQuery<Fine> query = em.createQuery(jpal, Fine.class);
        query.setParameter("user", user);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

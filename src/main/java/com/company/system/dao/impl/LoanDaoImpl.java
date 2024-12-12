package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockTimeoutException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Loan;
import com.company.system.model.User;

public class LoanDaoImpl implements LoanDao{
    private final EntityManagerFactory emf;

    public LoanDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Loan object) {
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
    public List<Loan> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Loan> findAllIncludeDeleted() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllIncludeDeleted'");
    }

    @Override
    public Loan findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Loan findByIdIncludeDeleted(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdIncludeDeleted'");
    }

    @Override
    public boolean update(Loan object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public List<Loan> findByUser(User user) throws QueryTimeoutException, TransactionRequiredException, PessimisticLockException, LockTimeoutException {
        EntityManager em = getEntityManager();
        String jpal = "SELECT l FROM Loan l WHERE l.user = :user AND l.deleted=0";
        TypedQuery<Loan> query = em.createQuery(jpal, Loan.class);
        query.setParameter("user", user);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

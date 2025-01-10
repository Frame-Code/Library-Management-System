package com.company.system.dao.impl;

import com.company.system.dao.interfaces.DevolutionDao;
import com.company.system.model.Devolution;
import com.company.system.model.Loan;
import com.company.system.model.User;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class DevolutionDaoImpl implements DevolutionDao {

    private final EntityManagerFactory emf;

    public DevolutionDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Devolution object) {
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
    public List<Devolution> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Devolution> findAllIncludeDeleted() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Devolution findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Devolution findByIdIncludeDeleted(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Devolution object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Devolution> findByStudent(User student) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT d Devolution d WHERE d.user = :user AND d.deleted = 0";
        TypedQuery<Devolution> query = em.createQuery(jpql, Devolution.class);
        query.setParameter("user", student);
        List<Devolution> devolutions;
        try {
            devolutions = query.getResultList();
            return devolutions;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

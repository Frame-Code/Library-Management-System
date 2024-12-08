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
 * Esta clase implementa los metodos necesarios para el acceso a la base de
 * datos de la tabla User
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf;

    //Contructor que crea un EntityManagerFactory a partir de la unidad de persistencia definidado con el nombre 
    //"libraryPU"
    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Este metodo crea un nuevo registro en la base de datos a la tabla User
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
        }
    }

    //Este metodo trae todos los registros de la base de datos de la tabla User
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    //Este metodo trae un User de la base de datos en base a su id
    @Override
    public User findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: no se puede crear ");
        } finally {
            em.close();
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
        String jpql = "SELECT u FROM User u WHERE u.idCardUser = :idCard AND u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("idCard", idCard);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public User findByIdCard(Long idCard, String role) {
        User user = findByIdCard(idCard);
        if (user != null) {
            if (user.getRole().getName().equals(role)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

}

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
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> users;
        try {
            users = query.getResultList();
            return users;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    //Este metodo trae un User de la base de datos en base a su id
    @Override
    public User findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.idUser = :id AND u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("id", id);
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
    public boolean update(User object) {
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
        User user = findById(id); 
        user.setDeleted(true);
        return update(user);
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

    @Override
    public boolean deleteByIdCard(Long idCardUser) {
        User user = findByIdCard(idCardUser); 
        user.setDeleted(true);
        return update(user);
    }

    @Override
    public List<User> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> users;
        try {
            users = query.getResultList();
            return users;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public User findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.idUser = :id";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("id", id);
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
    public User findByEmail(String email) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.email = :email AND u.deleted = 0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);
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

}

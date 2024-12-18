package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.RoleDao;
import com.company.system.model.Role;

/**
 * Esta clase implementa los metodos necesarios para el acceso a la base de datos de la tabla Role
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RoleDaoImpl implements RoleDao{
    private final EntityManagerFactory emf;
    
    //Contructor que crea un EntityManagerFactory a partir de la unidad de persistencia definidado con el nombre 
    //"libraryPU"
    public RoleDaoImpl() {
        emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Este metodo crea un nuevo registro en la base de datos a la tabla Role
    @Override
    public boolean create(Role object) {
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
    
    //Este metodo trae todos los registros de la base de datos de la tabla Role
    @Override
    public List<Role> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r WHERE r.deleted=0";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        List<Role> role;
        try {
            role = query.getResultList();
            return role;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    //Este metodo trae un Rol de la base de datos en base a su id
    @Override
    public Role findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r WHERE r.id = :id AND r.deleted=0";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        query.setParameter("id", id);
        Role role;
        try {
            role = query.getSingleResult();
            return role;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    //Este metodo actualiza la informacion de un registro
    @Override
    public boolean update(Role object) {
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
    
    //Este metodo "elimina" logicamente un registro de la base de datos
    //Cambiando de valor al campo idDeleted a 1, significando que no se puede acceder a el
    @Override
    public boolean deleteByID(Long id) {
        Role role = findById(id); 
        role.setDeleted(true);
        return update(role);
    }
    
    //Este metodo trae de la base de datos el rol a partir de su nombre 
    //(teniendo en cuenta que solo puede existir un rol con un solo nombre unico)
    @Override
    public Role findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r WHERE r.name = :name AND r.deleted=0";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        query.setParameter("name", name);
        Role role;
        try {
            role = query.getSingleResult();
            return role;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Role> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        List<Role> roles;
        try {
            roles = query.getResultList();
            return roles;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Role findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r WHERE r.idR = :id";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        query.setParameter("id", id);
        Role role;
        try {
            role = query.getSingleResult();
            return role;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}

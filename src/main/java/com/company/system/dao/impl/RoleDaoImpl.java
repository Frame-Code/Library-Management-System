package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.RoleDao;
import com.company.system.model.Role;
import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RoleDaoImpl implements RoleDao{
    private final EntityManagerFactory emf;
    
    public RoleDaoImpl() {
        emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Role object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Role findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Role.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Error: id no encontrado");
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Role object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public Role findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT r FROM Role r WHERE r.name = :name";
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

}

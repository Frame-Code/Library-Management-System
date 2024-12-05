package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.company.system.dao.interfaces.RoleDao;
import com.company.system.model.Role;

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

}

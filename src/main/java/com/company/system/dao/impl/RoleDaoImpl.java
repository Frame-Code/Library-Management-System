package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
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
        emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Este metodo crea un nuevo registro en la base de datos a la tabla Role
    @Override
    public boolean create(Role object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
    //Este metodo trae todos los registros de la base de datos de la tabla Role
    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
    //Este metodo trae un Rol de la base de datos en base a su id
    @Override
    public Role findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Role.class, id); //CREAR CONSULTA JPQL DONDE VERIFICA LA CAMPO ISDELETED
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Error: id no encontrado");
        } finally {
            em.close();
        }
    }
    
    //Este metodo actualiza la informacion de un registro
    @Override
    public boolean update(Role object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
    //Este metodo "elimina" logicamente un registro de la base de datos
    //Cambiando de valor al campo idDeleted a 1, significando que no se puede acceder a el
    @Override
    public boolean deleteByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
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

}

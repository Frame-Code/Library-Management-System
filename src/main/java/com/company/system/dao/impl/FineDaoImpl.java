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
import com.company.system.model.User;

public class FineDaoImpl implements FineDao {
    
    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public FineDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear una nueva multa en la base de datos
    @Override
    public boolean create(Fine object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste la multa
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true; // Retorna verdadero si la transacción fue exitosa
        } catch (IllegalStateException | EntityExistsException | TransactionRequiredException e) {
            // Si ocurre un error, revierte la transacción y retorna falso
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todas las multas no eliminadas
    @Override
    public List<Fine> findAll() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todas las multas no eliminadas
        String jpql = "SELECT f FROM Fine f WHERE f.deleted=0";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todas las multas, incluyendo las eliminadas
    @Override
    public List<Fine> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todas las multas, sin importar si están eliminadas o no
        String jpql = "SELECT f FROM Fine f";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener una multa por su ID, asegurándose de que no esté marcada como eliminada
    @Override
    public Fine findById(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener una multa por su ID y asegurándose de que no esté eliminada
        String jpql = "SELECT f FROM Fine f WHERE f.idFine = :id AND f.deleted = 0";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        query.setParameter("id", id);
        Fine fine;
        try {
            fine = query.getSingleResult();
            return fine;
        } catch (NoResultException e) {
            // Si no se encuentra la multa, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener una multa por su ID, incluyendo las eliminadas
    @Override
    public Fine findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener una multa por su ID, sin importar si está eliminada o no
        String jpql = "SELECT f FROM Fine f WHERE f.idFine = :id";
        TypedQuery<Fine> query = em.createQuery(jpql, Fine.class);
        query.setParameter("id", id);
        Fine fine;
        try {
            fine = query.getSingleResult();
            return fine;
        } catch (NoResultException e) {
            // Si no se encuentra la multa, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar una multa en la base de datos
    @Override
    public boolean update(Fine object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza la multa
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true; // Retorna verdadero si la transacción fue exitosa
        } catch (IllegalStateException | TransactionRequiredException | IllegalArgumentException
                | RollbackException e) {
            // Si ocurre un error, revierte la transacción y retorna falso
            em.getTransaction().rollback();
            return false;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para eliminar una multa por su ID, marcándola como eliminada
    @Override
    public boolean deleteByID(Long id) {
        // Busca la multa por su ID
        Fine fine = findById(id);
        // Marca la multa como eliminada
        fine.setDeleted(true);
        // Actualiza la multa con la nueva información (marcada como eliminada)
        return update(fine);
    }

    // Método para encontrar todas las multas asociadas a un usuario
    @Override
    public List<Fine> findByUser(User user) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todas las multas asociadas a un usuario específico y no eliminadas
        String jpal = "SELECT f FROM Fine f WHERE f.user = :user AND f.deleted=0";
        TypedQuery<Fine> query = em.createQuery(jpal, Fine.class);
        query.setParameter("user", user);
        List<Fine> fines;
        try {
            fines = query.getResultList();
            return fines;
        } catch (IllegalStateException | PersistenceException e) {
            // Si ocurre un error o no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}

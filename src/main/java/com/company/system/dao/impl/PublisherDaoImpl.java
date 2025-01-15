package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.model.Publisher;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class PublisherDaoImpl implements PublisherDao {

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private final EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public PublisherDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un nuevo editor en la base de datos
    @Override
    public boolean create(Publisher object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste el editor
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

    // Método para obtener todos los editores no eliminados
    @Override
    public List<Publisher> findAll() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los editores no eliminados
        String jpql = "SELECT p FROM Publisher p WHERE p.deleted=0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        List<Publisher> publishers;
        try {
            publishers = query.getResultList();
            return publishers;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todos los editores, incluyendo los eliminados
    @Override
    public List<Publisher> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los editores, sin importar si están eliminados o no
        String jpql = "SELECT p FROM Publisher p";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        List<Publisher> publishers;
        try {
            publishers = query.getResultList();
            return publishers;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un editor por su ID, asegurándose de que no esté marcado como eliminado
    @Override
    public Publisher findById(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un editor por su ID y asegurándose de que no esté eliminado
        String jpql = "SELECT p FROM Publisher p WHERE p.idPublisher = :id AND p.deleted = 0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("id", id);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            // Si no se encuentra el editor, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un editor por su ID, incluyendo los eliminados
    @Override
    public Publisher findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un editor por su ID, sin importar si está eliminado o no
        String jpql = "SELECT p FROM Publisher p WHERE p.idPublisher = :id";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("id", id);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            // Si no se encuentra el editor, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar un editor en la base de datos
    @Override
    public boolean update(Publisher object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza el editor
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true; // Retorna verdadero si la transacción fue exitosa
        } catch (IllegalStateException | TransactionRequiredException | IllegalArgumentException | RollbackException e) {
            // Si ocurre un error, revierte la transacción y retorna falso
            em.getTransaction().rollback();
            return false;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para eliminar un editor por su ID, marcándolo como eliminado
    @Override
    public boolean deleteByID(Long id) {
        // Busca el editor por su ID
        Publisher publisher = findById(id);
        // Marca el editor como eliminado
        publisher.setDeleted(true);
        // Actualiza el editor con la nueva información (marcado como eliminado)
        return update(publisher);
    }

    // Método para obtener un editor por su nombre, asegurándose de que no esté marcado como eliminado
    @Override
    public Publisher findByName(String name) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un editor por su nombre y asegurándose de que no esté eliminado
        String jpql = "SELECT p FROM Publisher p WHERE p.name=:name AND p.deleted=0";
        TypedQuery<Publisher> query = em.createQuery(jpql, Publisher.class);
        query.setParameter("name", name);
        Publisher publisher;
        try {
            publisher = query.getSingleResult();
            return publisher;
        } catch (NoResultException e) {
            // Si no se encuentra el editor, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}


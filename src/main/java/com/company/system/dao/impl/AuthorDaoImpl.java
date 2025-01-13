package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.AuthorDao;
import com.company.system.model.Author;

/**
 *
 * @author Daniel Mora Cantillo
 */
public class AuthorDaoImpl implements AuthorDao {

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public AuthorDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un nuevo autor en la base de datos
    @Override
    public boolean create(Author object) {
        // Obtiene un EntityManager para gestionar la transacción
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste el autor en la base de datos
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true; // Retorna verdadero si la transacción fue exitosa
        } catch (IllegalStateException | EntityExistsException | TransactionRequiredException e) {
            // Si ocurre una excepción, imprime la traza de la excepción y revierte la transacción
            e.printStackTrace();
            em.getTransaction().rollback();
            return false; // Retorna falso si ocurrió un error
        } finally {
            // Cierra el EntityManager para liberar los recursos
            em.close();
        }
    }

    // Método para obtener una lista de todos los autores que no han sido marcados como eliminados
    @Override
    public List<Author> findAll() {
        // Obtiene un EntityManager para interactuar con la base de datos
        EntityManager em = getEntityManager();
        // Consulta JPQL que obtiene autores cuyo campo 'deleted' es 0 (no eliminados)
        String jpql = "SELECT a FROM Author a WHERE a.deleted=0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        List<Author> authors;
        try {
            // Ejecuta la consulta y obtiene la lista de autores
            authors = query.getResultList();
            return authors;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todos los autores, incluyendo aquellos que han sido marcados como eliminados
    @Override
    public List<Author> findAllIncludeDeleted() {
        // Obtiene un EntityManager
        EntityManager em = getEntityManager();
        // Consulta JPQL que obtiene todos los autores, sin importar si están eliminados o no
        String jpql = "SELECT a FROM Author a";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        List<Author> authors;
        try {
            // Ejecuta la consulta y obtiene la lista de autores
            authors = query.getResultList();
            return authors;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para encontrar un autor por su ID, excluyendo aquellos marcados como eliminados
    @Override
    public Author findById(Long id) {
        // Obtiene un EntityManager
        EntityManager em = getEntityManager();
        // Consulta JPQL para encontrar un autor por su ID y asegurar que no esté eliminado
        String jpql = "SELECT a FROM Author a WHERE a.idAuthor = :id and a.deleted = 0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        query.setParameter("id", id);
        Author author;
        try {
            // Ejecuta la consulta y obtiene el autor
            author = query.getSingleResult();
            return author;
        } catch (NoResultException e) {
            // Si no se encuentra el autor, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para encontrar un autor por su ID, incluyendo aquellos marcados como eliminados
    @Override
    public Author findByIdIncludeDeleted(Long id) {
        // Obtiene un EntityManager
        EntityManager em = getEntityManager();
        Author author;
        try {
            // Inicia la transacción y busca el autor por su ID
            em.getTransaction().begin();
            author = em.find(Author.class, id);
            em.getTransaction().commit();
            return author; // Retorna el autor encontrado
        } catch (IllegalStateException | IllegalArgumentException | RollbackException e) {
            // Si ocurre un error, revierte la transacción y retorna null
            em.getTransaction().rollback();
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar la información de un autor en la base de datos
    @Override
    public boolean update(Author object) {
        // Obtiene un EntityManager
        EntityManager em = getEntityManager();
        try {
            // Inicia la transacción y actualiza el autor
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

    // Método para eliminar un autor por su ID, marcándolo como eliminado (en lugar de eliminarlo físicamente)
    @Override
    public boolean deleteByID(Long id) {
        // Busca el autor por su ID
        Author author = findById(id);
        // Marca al autor como eliminado
        author.setDeleted(true);
        // Actualiza el autor con la nueva información (marcado como eliminado)
        return update(author);
    }

}

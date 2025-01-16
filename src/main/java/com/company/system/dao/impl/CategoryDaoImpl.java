package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.CategoryDao;
import com.company.system.model.Category;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class CategoryDaoImpl implements CategoryDao {

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public CategoryDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear una nueva categoría en la base de datos
    @Override
    public boolean create(Category object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste la categoría
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

    // Método para obtener todas las categorías no eliminadas
    @Override
    public List<Category> findAll() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todas las categorías no eliminadas
        String jpql = "SELECT c FROM Category c WHERE c.deleted=0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        List<Category> categories;
        try {
            categories = query.getResultList();
            return categories;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener una categoría por su ID, asegurándose de que no esté marcada como eliminada
    @Override
    public Category findById(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener una categoría por su ID y asegurarse de que no esté eliminada
        String jpql = "SELECT c FROM Category c WHERE c.idCategory = :id and c.deleted = 0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("id", id);
        Category category;
        try {
            category = query.getSingleResult();
            return category;
        } catch (NoResultException e) {
            // Si no se encuentra la categoría, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar una categoría en la base de datos
    @Override
    public boolean update(Category object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza la categoría
            em.getTransaction().begin();
            em.merge(object);
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

    // Método para eliminar una categoría por su ID, marcándola como eliminada
    @Override
    public boolean deleteByID(Long id) {
        // Busca la categoría por su ID
        Category category = findById(id);
        // Marca la categoría como eliminada
        category.setDeleted(true);
        // Actualiza la categoría con la nueva información (marcada como eliminada)
        return update(category);
    }

    // Método para encontrar una categoría por su nombre, asegurándose de que no esté eliminada
    @Override
    public Category findByName(String name) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener una categoría por su nombre
        String jpql = "SELECT c FROM Category c WHERE c.name = :name AND c.deleted=0";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("name", name);
        Category category;
        try {
            category = query.getSingleResult();
            return category;
        } catch (NoResultException e) {
            // Si no se encuentra la categoría, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todas las categorías, incluyendo las eliminadas
    @Override
    public List<Category> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todas las categorías, sin importar si están eliminadas o no
        String jpql = "SELECT c FROM Category c";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        List<Category> categories;
        try {
            categories = query.getResultList();
            return categories;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener una categoría por su ID, incluyendo las eliminadas
    @Override
    public Category findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener una categoría por su ID, sin importar si está eliminada o no
        String jpql = "SELECT c FROM Category c WHERE c.idCategory = :id";
        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setParameter("id", id);
        Category category;
        try {
            category = query.getSingleResult();
            return category;
        } catch (NoResultException e) {
            // Si no se encuentra la categoría, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}


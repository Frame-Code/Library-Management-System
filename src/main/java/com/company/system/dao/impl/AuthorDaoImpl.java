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
    private EntityManagerFactory emf;

    public AuthorDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Author object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException | EntityExistsException | TransactionRequiredException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Author> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Author a WHERE a.deleted=0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        List<Author> authors;
        try {
            authors = query.getResultList();
            return authors;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Author> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Author a";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        List<Author> authors;
        try {
            authors = query.getResultList();
            return authors;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Author findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Author a WHERE a.idAuthor = :id and a.deleted = 0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        query.setParameter("id", id);
        Author author;
        try {
            author = query.getSingleResult();
            return author;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Author findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        Author author;
        try {
            em.getTransaction().begin();;
            author = em.find(Author.class, id);
            em.getTransaction().commit();
            return author;
        } catch (IllegalStateException | IllegalArgumentException | RollbackException e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Author object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException | TransactionRequiredException | IllegalArgumentException
                | RollbackException e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        Author author = findById(id);
        author.setDeleted(true);
        return update(author);
    }

    @Override
    public List<Author> findByName(String name) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Author a WHERE (LOWER(a.names) LIKE :name OR LOWER(a.surNames) LIKE :name) AND a.deleted = 0";
        TypedQuery<Author> query = em.createQuery(jpql, Author.class);
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        List<Author> authors;
        try {
            authors = query.getResultList();
            return authors;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

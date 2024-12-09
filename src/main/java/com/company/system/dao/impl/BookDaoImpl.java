package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Book;
import com.company.system.model.Category;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class BookDaoImpl implements BookDao{
    private final EntityManagerFactory emf;

    public BookDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    } 

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Book object) {
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

    @Override
    public List<Book> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        List<Book> books;
        try {
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Book findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id and b.deleted = 0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("id", id);
        Book book;
        try {
            book = query.getSingleResult();
            return book;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Book object) {
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
        Book book = findById(id); 
        book.setDeleted(true);
        return update(book);
    }

    @Override
    public List<Book> findByCategory(Category category) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.category = :cat AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("cat", category);
        List<Book> books;
        try {
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Book findByISBN(String isbn) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.isbn = :isbn AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("isbn", isbn);
        Book book;
        try {
            book = query.getSingleResult();
            return book;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Book> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        List<Book> books;
        try {
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Book findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("id", id);
        Book book;
        try {
            book = query.getSingleResult();
            return book;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

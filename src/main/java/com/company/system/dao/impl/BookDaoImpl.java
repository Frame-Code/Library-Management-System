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
import com.company.system.model.Author;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class BookDaoImpl implements BookDao {

    private final EntityManagerFactory emf;

    public BookDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory("libraryPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private List<Book> findList(String jpql) {
        EntityManager em = getEntityManager();
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

    private Book findUnique(String jpql, String parameter, Long id) {
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter(parameter, id);
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

    private <T> List<Book> findListBySome(String jpql, String parameter, T objectToSet) {
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter(parameter, objectToSet);
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
        String jpql = "SELECT b FROM Book b WHERE b.deleted=0";
        return findList(jpql);

    }

    @Override
    public Book findById(Long id) {
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id and b.deleted = 0";
        return findUnique(jpql, "id", id);
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
        String jpql = "SELECT b FROM Book b WHERE b.category = :cat AND b.deleted=0";
        return findListBySome(jpql, "cat", category);

    }

    @Override
    public List<Book> findByAuthor(Author author) {
        String jpql = "SELECT b FROM Book b JOIN b.authors a WHERE a = :author AND b.deleted=0";
        return findListBySome(jpql, "author", author);
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher) {
        String jpql = "SELECT b FROM Book b WHERE b.publisher = :publisher AND b.deleted=0";
        return findListBySome(jpql, "publisher", publisher);
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
        String jpql = "SELECT b FROM Book b";
        return findList(jpql);
    }

    @Override
    public Book findByIdIncludeDeleted(Long id) {
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id";
        return findUnique(jpql, "id", id);
    }

    @Override
    public List<Book> findByPattern(String pattern) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE :pattern AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("pattern", "%" + pattern + "%");
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

}

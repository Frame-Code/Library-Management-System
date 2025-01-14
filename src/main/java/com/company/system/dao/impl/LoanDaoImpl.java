package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockTimeoutException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Book;
import com.company.system.model.Loan;
import com.company.system.model.User;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoanDaoImpl implements LoanDao {

    private final EntityManagerFactory emf;

    public LoanDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Loan object) {
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
    public List<Loan> findAll() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.deleted=0";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Loan> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Loan findById(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.idLoan = :id AND l.deleted = 0";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("id", id);
        Loan loan;
        try {
            loan = query.getSingleResult();
            return loan;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Loan findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.idLoan = :id";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("id", id);
        Loan loan;
        try {
            loan = query.getSingleResult();
            return loan;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Loan object) {
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
        Loan loan = findById(id);
        loan.setDeleted(true);
        return update(loan);
    }

    @Override
    public List<Loan> findByUser(User user)
            throws QueryTimeoutException, TransactionRequiredException, PessimisticLockException, LockTimeoutException {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.user = :user AND l.deleted=0";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("user", user);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Loan> findRecentLoans(int limit) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.deleted=0 ORDER BY l.registrationDate DESC ";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setMaxResults(limit);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Explicacion JPQL: Selecciona el titulo, isbn del libro y hace un conteo
     * de los prestamos El titulo y el isbn son obtenidos por el JOIN a traves
     * la entidad Loan (FROM Loan l JOIN l.book b) La condicion WHERE l.deleted
     * = 0 es para obtener solo los prestamos que no han sido eliminados
     *
     * Agrupa por titulo y isbn para que el conteo sea por cada libro que ha
     * sido prestado Ordena las filas por los valores de la columna totalLoans
     * de forma descendente
     *
     * La consulta devuelve una lista de arreglos de objetos, donde cada arreglo
     * contiene el titulo, isbn y total de prestamos en ese orden
     */
    @Override
    public List<Object[]> findMostBorrowedBooks(int limit) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT b.title, b.isbn, COUNT(l) AS totalLoans "
                + "FROM Loan l "
                + "JOIN l.book b "
                + "WHERE l.deleted = 0 "
                + "GROUP BY b.title, b.isbn "
                + "ORDER BY totalLoans DESC";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setMaxResults(limit);
        List<Object[]> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Loan findLoanForDevolution(User student, Book book) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT l FROM Loan l WHERE l.deleted=0 AND l.book = :book "
                + "AND l.user = :user AND l.returned = 0 AND l.devolution IS NULL";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("user", student);
        query.setParameter("book", book);
        Loan loan;
        try {
            loan = query.getSingleResult();
            return loan;
        } catch (IllegalStateException | PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

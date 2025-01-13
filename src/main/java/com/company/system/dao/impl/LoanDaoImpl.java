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
import com.company.system.model.Loan;
import com.company.system.model.User;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoanDaoImpl implements LoanDao {

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private final EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public LoanDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un nuevo préstamo en la base de datos
    @Override
    public boolean create(Loan object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste el préstamo
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

    // Método para obtener todos los préstamos no eliminados
    @Override
    public List<Loan> findAll() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los préstamos no eliminados
        String jpql = "SELECT l FROM Loan l WHERE l.deleted=0";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todos los préstamos, incluyendo los eliminados
    @Override
    public List<Loan> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los préstamos, sin importar si están eliminados o no
        String jpql = "SELECT l FROM Loan l";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un préstamo por su ID, asegurándose de que no esté marcado como eliminado
    @Override
    public Loan findById(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un préstamo por su ID y asegurándose de que no esté eliminado
        String jpql = "SELECT l FROM Loan l WHERE l.idLoan = :id AND l.deleted = 0";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("id", id);
        Loan loan;
        try {
            loan = query.getSingleResult();
            return loan;
        } catch (NoResultException e) {
            // Si no se encuentra el préstamo, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un préstamo por su ID, incluyendo los eliminados
    @Override
    public Loan findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un préstamo por su ID, sin importar si está eliminado o no
        String jpql = "SELECT l FROM Loan l WHERE l.idLoan = :id";
        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
        query.setParameter("id", id);
        Loan loan;
        try {
            loan = query.getSingleResult();
            return loan;
        } catch (NoResultException e) {
            // Si no se encuentra el préstamo, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar un préstamo en la base de datos
    @Override
    public boolean update(Loan object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza el préstamo
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

    // Método para eliminar un préstamo por su ID, marcándolo como eliminado
    @Override
    public boolean deleteByID(Long id) {
        // Busca el préstamo por su ID
        Loan loan = findById(id);
        // Marca el préstamo como eliminado
        loan.setDeleted(true);
        // Actualiza el préstamo con la nueva información (marcado como eliminado)
        return update(loan);
    }

    // Método para obtener todos los préstamos asociados a un usuario específico
    @Override
    public List<Loan> findByUser(User user) throws QueryTimeoutException, TransactionRequiredException, PessimisticLockException, LockTimeoutException {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los préstamos asociados a un usuario específico y no eliminados
        String jpal = "SELECT l FROM Loan l WHERE l.user = :user AND l.deleted=0";
        TypedQuery<Loan> query = em.createQuery(jpal, Loan.class);
        query.setParameter("user", user);
        List<Loan> loans;
        try {
            loans = query.getResultList();
            return loans;
        } catch (IllegalStateException | PersistenceException e) {
            // Si ocurre un error o no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}


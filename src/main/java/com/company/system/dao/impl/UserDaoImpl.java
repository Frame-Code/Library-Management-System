package com.company.system.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.User;

/**
 * Esta clase implementa los metodos necesarios para el acceso a la base de
 * datos de la tabla User
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserDaoImpl implements UserDao {

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un nuevo usuario en la base de datos
    @Override
    public boolean create(User object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste el usuario
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

    // Método para obtener todos los usuarios no eliminados
    @Override
    public List<User> findAll() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los usuarios no eliminados
        String jpql = "SELECT u FROM User u WHERE u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> users;
        try {
            users = query.getResultList();
            return users;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un usuario por su ID, asegurándose de que no esté marcado como eliminado
    @Override
    public User findById(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un usuario por su ID y asegurándose de que no esté eliminado
        String jpql = "SELECT u FROM User u WHERE u.idUser = :id AND u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("id", id);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            // Si no se encuentra el usuario, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para actualizar un usuario en la base de datos
    @Override
    public boolean update(User object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza el usuario
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

    // Método para eliminar un usuario por su ID, marcándolo como eliminado
    @Override
    public boolean deleteByID(Long id) {
        // Busca el usuario por su ID
        User user = findById(id);
        // Marca el usuario como eliminado
        user.setDeleted(true);
        // Actualiza el usuario con la nueva información (marcado como eliminado)
        return update(user);
    }

    // Método para obtener un usuario por su número de cédula, asegurándose de que no esté marcado como eliminado
    @Override
    public User findByIdCard(Long idCard) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un usuario por su número de cédula y asegurándose de que no esté eliminado
        String jpql = "SELECT u FROM User u WHERE u.idCardUser = :idCard AND u.deleted=0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("idCard", idCard);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            // Si no se encuentra el usuario, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un usuario por su número de cédula y rol, asegurándose de que coincidan
    @Override
    public User findByIdCard(Long idCard, String role) {
        User user = findByIdCard(idCard);
        if (user != null) {
            // Verifica si el rol del usuario coincide con el proporcionado
            if (user.getRole().getName().equals(role)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // Método para eliminar un usuario por su número de cédula, marcándolo como eliminado
    @Override
    public boolean deleteByIdCard(Long idCardUser) {
        // Busca el usuario por su número de cédula
        User user = findByIdCard(idCardUser);
        // Marca el usuario como eliminado
        user.setDeleted(true);
        // Actualiza el usuario con la nueva información (marcado como eliminado)
        return update(user);
    }

    // Método para obtener todos los usuarios, incluyendo los eliminados
    @Override
    public List<User> findAllIncludeDeleted() {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener todos los usuarios, sin importar si están eliminados o no
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> users;
        try {
            users = query.getResultList();
            return users;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un usuario por su ID, incluyendo los eliminados
    @Override
    public User findByIdIncludeDeleted(Long id) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un usuario por su ID, sin importar si está eliminado o no
        String jpql = "SELECT u FROM User u WHERE u.idUser = :id";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("id", id);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            // Si no se encuentra el usuario, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener un usuario por su correo electrónico, asegurándose de que no esté marcado como eliminado
    @Override
    public User findByEmail(String email) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un usuario por su correo electrónico y asegurándose de que no esté eliminado
        String jpql = "SELECT u FROM User u WHERE u.email = :email AND u.deleted = 0";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);
        User user;
        try {
            user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            // Si no se encuentra el usuario, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}


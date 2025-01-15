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

    // Atributo privado que almacena la fábrica de EntityManager para la gestión de transacciones
    private final EntityManagerFactory emf;

    // Constructor que inicializa la fábrica de EntityManager utilizando la unidad de persistencia configurada
    public BookDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(namePersistenceUnit);
    }

    // Método privado que obtiene una nueva instancia de EntityManager para interactuar con la base de datos
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método privado genérico para ejecutar una consulta que retorna una lista de libros
    private List<Book> findList(String jpql) {
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        List<Book> books;
        try {
            // Ejecuta la consulta y obtiene la lista de libros
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método privado que ejecuta una consulta que retorna un único libro según el JPQL y el parámetro ID
    private Book findUnique(String jpql, String parameter, Long id) {
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter(parameter, id);
        Book book;
        try {
            // Ejecuta la consulta y obtiene un único libro
            book = query.getSingleResult();
            return book;
        } catch (NoResultException e) {
            // Si no se encuentra el libro, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método privado genérico para ejecutar una consulta que retorna una lista de libros
    // según un parámetro adicional
    private <T> List<Book> findListBySome(String jpql, String parameter, T objectToSet) {
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter(parameter, objectToSet);
        List<Book> books;
        try {
            // Ejecuta la consulta y obtiene la lista de libros
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para crear un nuevo libro en la base de datos
    @Override
    public boolean create(Book object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y persiste el libro
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

    // Método para obtener todos los libros no eliminados
    @Override
    public List<Book> findAll() {
        // Consulta JPQL para obtener todos los libros no eliminados
        String jpql = "SELECT b FROM Book b WHERE b.deleted=0";
        return findList(jpql);
    }

    // Método para obtener un libro por su ID, asegurándose de que no esté marcado como eliminado
    @Override
    public Book findById(Long id) {
        // Consulta JPQL para obtener un libro por su ID y asegurarse de que no esté eliminado
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id and b.deleted = 0";
        return findUnique(jpql, "id", id);
    }

    // Método para actualizar un libro en la base de datos
    @Override
    public boolean update(Book object) {
        EntityManager em = getEntityManager();
        try {
            // Inicia una transacción y actualiza el libro
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

    // Método para eliminar un libro por su ID, marcándolo como eliminado
    @Override
    public boolean deleteByID(Long id) {
        // Busca el libro por su ID
        Book book = findById(id);
        // Marca el libro como eliminado
        book.setDeleted(true);
        // Actualiza el libro con la nueva información (marcado como eliminado)
        return update(book);
    }

    // Método para encontrar libros por su categoría
    @Override
    public List<Book> findByCategory(Category category) {
        // Consulta JPQL para obtener libros por su categoría
        String jpql = "SELECT b FROM Book b WHERE b.category = :cat AND b.deleted=0";
        return findListBySome(jpql, "cat", category);
    }

    // Método para encontrar libros por su autor
    @Override
    public List<Book> findByAuthor(Author author) {
        // Consulta JPQL para obtener libros por su autor
        String jpql = "SELECT b FROM Book b JOIN b.authors a WHERE a = :author AND b.deleted=0";
        return findListBySome(jpql, "author", author);
    }

    // Método para encontrar libros por su editor (publisher)
    @Override
    public List<Book> findByPublisher(Publisher publisher) {
        // Consulta JPQL para obtener libros por su editor
        String jpql = "SELECT b FROM Book b WHERE b.publisher = :publisher AND b.deleted=0";
        return findListBySome(jpql, "publisher", publisher);
    }

    // Método para encontrar un libro por su ISBN
    @Override
    public Book findByISBN(String isbn) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para obtener un libro por su ISBN
        String jpql = "SELECT b FROM Book b WHERE b.isbn = :isbn AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("isbn", isbn);
        Book book;
        try {
            // Ejecuta la consulta y obtiene el libro
            book = query.getSingleResult();
            return book;
        } catch (NoResultException e) {
            // Si no se encuentra el libro, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    // Método para obtener todos los libros, incluyendo los eliminados
    @Override
    public List<Book> findAllIncludeDeleted() {
        // Consulta JPQL para obtener todos los libros sin importar si están eliminados o no
        String jpql = "SELECT b FROM Book b";
        return findList(jpql);
    }

    // Método para obtener un libro por su ID, incluyendo los eliminados
    @Override
    public Book findByIdIncludeDeleted(Long id) {
        // Consulta JPQL para obtener un libro por su ID, sin importar si está eliminado o no
        String jpql = "SELECT b FROM Book b WHERE b.idBook = :id";
        return findUnique(jpql, "id", id);
    }

    // Método para encontrar libros por un patrón en su título (búsqueda por patrón)
    @Override
    public List<Book> findByPattern(String pattern) {
        EntityManager em = getEntityManager();
        // Consulta JPQL para buscar libros cuyo título contenga el patrón (case-insensitive)
        String jpql = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE :pattern AND b.deleted=0";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("pattern", "%" + pattern + "%");
        List<Book> books;
        try {
            // Ejecuta la consulta y obtiene los libros
            books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            // Si no se encuentran resultados, retorna null
            return null;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

}

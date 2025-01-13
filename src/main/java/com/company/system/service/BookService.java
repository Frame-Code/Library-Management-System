package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.BookDaoImpl;
import com.company.system.dao.interfaces.BookDao;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los libros.
 * Esta clase interactúa con la capa de acceso a datos a través de la interfaz BookDao.
 */
public class BookService {

    // Atributo que representa el objeto de acceso a datos para los libros.
    private BookDao bookDao;

    /**
     * Constructor de la clase BookService. Inicializa el objeto bookDao
     * utilizando la implementación concreta BookDaoImpl.
     */
    public BookService() {
        // Inicialización de bookDao con la implementación concreta
        this.bookDao = new BookDaoImpl();
    }

    /**
     * Obtiene una lista de libros filtrados por la categoría proporcionada.
     * 
     * @param category La categoría por la cual se desean filtrar los libros.
     * @return Una lista de libros que pertenecen a la categoría especificada.
     */
    public List<Book> getBooksByCategory(Category category) {
        // Llama al método findByCategory de bookDao para obtener los libros de la categoría
        return bookDao.findByCategory(category);
    }

    /**
     * Obtiene una lista de libros filtrados por el editor (publisher) proporcionado.
     * 
     * @param publisher El editor por el cual se desean filtrar los libros.
     * @return Una lista de libros que fueron publicados por el editor especificado.
     */
    public List<Book> getBooksByPublisher(Publisher publisher) {
        // Llama al método findByPublisher de bookDao para obtener los libros del editor
        return bookDao.findByPublisher(publisher);
    }

    /**
     * Obtiene un libro a partir de su ISBN.
     * 
     * @param isbn El ISBN del libro que se desea obtener.
     * @return El libro con el ISBN especificado, o null si no se encuentra.
     */
    public Book getBookByISBN(String isbn) {
        // Llama al método findByISBN de bookDao para obtener el libro por su ISBN
        return bookDao.findByISBN(isbn);
    }

    /**
     * Busca libros que coincidan con un patrón dado.
     * 
     * @param pattern El patrón de búsqueda (puede ser parte del título, autor, etc.).
     * @return Una lista de libros que coinciden con el patrón de búsqueda.
     */
    public List<Book> searchBook(String pattern) {
        // Llama al método findByPattern de bookDao para obtener los libros que coincidan con el patrón
        return bookDao.findByPattern(pattern);
    }

}

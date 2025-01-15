package com.company.system.service;
/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */

import java.util.List;

import com.company.system.dao.impl.CategoryDaoImpl;
import com.company.system.dao.interfaces.CategoryDao;
import com.company.system.model.Category;

/**
 * Clase encargada de gestionar las operaciones relacionadas con las categorías.
 * Esta clase interactúa con la capa de acceso a datos a través de la interfaz CategoryDao.
 */
public class CategoryService {

    // Atributo que representa el objeto de acceso a datos para las categorías.
    private CategoryDao categoryDAO;

    /**
     * Constructor de la clase CategoryService. Inicializa el objeto categoryDAO
     * utilizando la implementación concreta CategoryDaoImpl.
     */
    public CategoryService() {
        // Inicialización de categoryDAO con la implementación concreta
        categoryDAO = new CategoryDaoImpl();
    }

    /**
     * Obtiene una lista de todas las categorías disponibles.
     * 
     * @return Una lista de todas las categorías.
     */
    public List<Category> getCategories() {
        // Llama al método findAll de categoryDAO para obtener todas las categorías
        return categoryDAO.findAll();
    }

    /**
     * Obtiene una categoría a partir de su nombre.
     * 
     * @param name El nombre de la categoría que se desea obtener.
     * @return La categoría con el nombre especificado, o null si no se encuentra.
     */
    public Category getCategoryByName(String name) {
        // Llama al método findByName de categoryDAO para obtener la categoría por su nombre
        return categoryDAO.findByName(name);
    }

}

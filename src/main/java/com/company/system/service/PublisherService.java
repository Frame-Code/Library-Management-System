package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.PublisherDaoImpl;
import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.model.Publisher;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los editores (publishers).
 * Esta clase interactúa con la capa de acceso a datos a través de la interfaz PublisherDao.
 */
public class PublisherService {

    // Atributo que representa el objeto de acceso a datos para los editores.
    private final PublisherDao publisherDao;

    /**
     * Constructor de la clase PublisherService. Inicializa el objeto publisherDao
     * utilizando la implementación concreta PublisherDaoImpl.
     */
    public PublisherService() {
        // Inicialización de publisherDao con la implementación concreta
        this.publisherDao = new PublisherDaoImpl();
    }

    /**
     * Obtiene una lista de todos los editores disponibles.
     * 
     * @return Una lista de todos los editores.
     */
    public List<Publisher> getPublishers() {
        // Llama al método findAll de publisherDao para obtener todos los editores
        return publisherDao.findAll();
    }

    /**
     * Obtiene un editor a partir de su nombre.
     * 
     * @param name El nombre del editor que se desea obtener.
     * @return El editor con el nombre especificado, o null si no se encuentra.
     */
    public Publisher getPublisherByName(String name) {
        // Llama al método findByName de publisherDao para obtener el editor por su nombre
        return publisherDao.findByName(name);
    }
    
    
}

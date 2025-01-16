
package com.company.system.controller;

import com.company.system.service.BookService;
import com.company.system.view.ButtonDesign;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author jandr Ronald Seminario Santana
 */
/**
 * Clase ButtonDesignListener
 * 
 * Esta clase extiende de `MouseAdapter` y proporciona funcionalidad interactiva a un botón diseñado con la clase `ButtonDesign`.
 * Utiliza servicios de libros proporcionados por `BookService` para manejar eventos de clic y ofrece una experiencia visual más atractiva
 * cambiando el color del botón al interactuar con el mouse.
 * 
 * Propósito principal:
 * - Manejar eventos de mouse (`mouseEntered`, `mouseExited`, `mouseClicked`) para proporcionar retroalimentación visual 
 *   y funcionalidad a los botones que representan libros.
 */
public class ButtonDesignListener extends MouseAdapter {
    private final BookService bookService; // Servicio para manejar operaciones relacionadas con libros.
    private final ButtonDesign buttonDesign; // Representación visual personalizada del botón.

    /**
     * Constructor de ButtonDesignListener
     * 
     * @param buttonDesign Instancia del botón personalizado (ButtonDesign) al que se le asociará este listener.
     * @param bookService Servicio de libros para obtener información de los libros mediante ISBN.
     */
    public ButtonDesignListener(ButtonDesign buttonDesign, BookService bookService) {
        this.bookService = bookService;
        this.buttonDesign = buttonDesign;

        // Configurar el botón para que su fondo sea visible.
        buttonDesign.setOpaque(false);
    }

    /**
     * Evento: mouseEntered
     * 
     * Se ejecuta cuando el mouse entra en el área del botón.
     * Cambia el color de fondo del botón a un color más claro (indicación visual de "hover").
     * 
     * @param e Evento del mouse.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        buttonDesign.setBackground(new Color(200, 230, 255)); // Color de fondo más claro.
        buttonDesign.repaint(); // Actualiza la interfaz gráfica.
    }

    /**
     * Evento: mouseExited
     * 
     * Se ejecuta cuando el mouse sale del área del botón.
     * Restaura el color de fondo original (blanco).
     * 
     * @param e Evento del mouse.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        buttonDesign.setBackground(Color.WHITE); // Restaura el color original.
        buttonDesign.repaint(); // Actualiza la interfaz gráfica.
    }

    /**
     * Evento: mouseClicked
     * 
     * Se ejecuta cuando se hace clic en el botón.
     * Obtiene información del libro asociado al botón utilizando el ISBN proporcionado
     * y muestra la información del libro a través de la funcionalidad de `ButtonDesign`.
     * 
     * @param e Evento del mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtiene el libro asociado al botón utilizando el ISBN y muestra su información.
        buttonDesign.openInfoBook(bookService.getBookByISBN(buttonDesign.getIsbnBook()));
    }
}
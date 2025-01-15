package com.company.system.controller;

import com.company.system.view.InfoLibroWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase InfoLibroWindowListener
 * 
 * Esta clase implementa `ActionListener` y `MouseListener` para manejar eventos relacionados con la ventana `InfoLibroWindow`,
 * en particular para el botón "Atrás" que permite cerrar la ventana o interactuar visualmente al pasar el mouse.
 */
public class InfoLibroWindowListener implements ActionListener, MouseListener {

    // Referencia a la ventana InfoLibroWindow
    private final InfoLibroWindow frmLibrowindow;

    /**
     * Constructor de InfoLibroWindowListener
     * 
     * @param frmLibrowindow Instancia de la ventana `InfoLibroWindow` asociada a este listener.
     *                       Se inicializa la referencia y se registran los listeners necesarios.
     */
    public InfoLibroWindowListener(InfoLibroWindow frmLibrowindow) {
        this.frmLibrowindow = frmLibrowindow;
        addListeners();
    }

    /**
     * Método para agregar los listeners al botón "Atrás".
     * - Se añade un `ActionListener` para manejar la acción del clic en el botón.
     * - Se añade un `MouseListener` para manejar la interacción visual (hover).
     */
    private void addListeners() {
        frmLibrowindow.getBtnBack().addActionListener(this);
        frmLibrowindow.getBtnBack().addMouseListener(this);
    }

    /**
     * Manejo de acciones de los botones.
     * Si se hace clic en el botón "Atrás", se cierra la ventana actual.
     * 
     * @param e Evento de acción capturado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.close(); // Cierra la ventana.
        }
    }

    /**
     * Manejo del evento cuando el mouse entra en el botón "Atrás".
     * Cambia el color o aspecto del botón según lo definido en `frmLibrowindow`.
     * 
     * @param e Evento del mouse capturado.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getBtnBack());
        }
    }

    /**
     * Manejo del evento cuando el mouse sale del botón "Atrás".
     * Restaura el color o aspecto original del botón según lo definido en `frmLibrowindow`.
     * 
     * @param e Evento del mouse capturado.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getBtnBack());
        }
    }

    /**
     * Manejo del evento de clic del mouse.
     * Actualmente no implementado.
     * 
     * @param e Evento del mouse capturado.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // No implementado.
    }

    /**
     * Manejo del evento cuando el botón del mouse se presiona.
     * Actualmente no implementado.
     * 
     * @param e Evento del mouse capturado.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // No implementado.
    }

    /**
     * Manejo del evento cuando el botón del mouse se suelta.
     * Actualmente no implementado.
     * 
     * @param e Evento del mouse capturado.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // No implementado.
    }
}

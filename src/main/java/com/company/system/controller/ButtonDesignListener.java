
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
public class ButtonDesignListener extends MouseAdapter {
    private final BookService bookService;

    private final ButtonDesign buttonDesign;

    public ButtonDesignListener(ButtonDesign buttonDesign, BookService bookService) {
        this.bookService = bookService;
        this.buttonDesign = buttonDesign;

        // Asegurarse de que el fondo es visible
        buttonDesign.setOpaque(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        buttonDesign.setBackground(new Color(200, 230, 255)); // Cambiar a un color más claro
        buttonDesign.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        buttonDesign.setBackground(Color.WHITE); // Restaurar el color original
        buttonDesign.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        buttonDesign.openInfoBook(bookService.getBookByISBN(buttonDesign.getIsbnBook()));
    }
}
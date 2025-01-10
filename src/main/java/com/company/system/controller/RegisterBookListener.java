
package com.company.system.controller;

import com.company.system.service.BookService;
import com.company.system.view.RegisterBook;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

/**
 *
 * @author HP240
 */
public class RegisterBookListener implements ActionListener, MouseListener, KeyListener{
    private RegisterBook pnlRegisterBook;
    private final BookService bookService;
    
    public RegisterBookListener(RegisterBook pnlRegisterBook, BookService bookService){
        this.pnlRegisterBook = pnlRegisterBook;
        this.bookService = bookService;
        addListener();
    }
    
    public void addListener(){
        pnlRegisterBook.getBtnRegisterBook().addActionListener(this);
        pnlRegisterBook.getBtnRegisterBook().addMouseListener(this);
        pnlRegisterBook.getBtnRegisterBook().addKeyListener(this);
    }
    
    private void verifyFields() {
        try {
            // Obtener valores del formulario
            String title = pnlRegisterBook.getTxtTitle().getText();
            String isbn = pnlRegisterBook.getTxtISBN().getText();
            String stock = pnlRegisterBook.getTxtStock().getText();
            String description = pnlRegisterBook.getTxaDescription().getText();
            String category = pnlRegisterBook.getCmbMonth().getSelectedItem().toString();
            String editorial = pnlRegisterBook.getCmbMonth().getSelectedItem().toString();
            String yearText = pnlRegisterBook.getTxtYear().getText();
            String monthText = pnlRegisterBook.getCmbMonth().getSelectedItem().toString();
            String dayText = pnlRegisterBook.getTxtDay().getText();

            // Validación de campos vacíos
            if (title.isEmpty() || isbn.isEmpty() || stock.isEmpty() || description.isEmpty() ||
                category.isEmpty() || editorial.isEmpty() || 
                yearText.isEmpty() || monthText.isEmpty() || dayText.isEmpty()) {
                pnlRegisterBook.errorMessage(pnlRegisterBook.errorEmptyFields);
                return;
            }

            // Validar y convertir datos numéricos
            try {
                int year = Integer.parseInt(yearText);
                int month = convertNumber(monthText);
                int day = Integer.parseInt(dayText);
                LocalDate publicationDate = LocalDate.of(year, month, day);
               
                // Registro del Libro
                boolean registered = false;
                if (registered) {
                    pnlRegisterBook.successMessage("Libro registrado exitosamente.");
                } else {
                    pnlRegisterBook.errorMessage("Ocurrió un error al registrar el libro.");
                }
            } catch (NumberFormatException ex) {
                pnlRegisterBook.errorMessage("Por favor ingresa valores numéricos válidos para la fecha.");
            }

        } catch (Exception ex) {
            pnlRegisterBook.errorMessage("Ocurrió un error inesperado: " + ex.getMessage());
        }
    }
    
    private int convertNumber(String month) {
        int numberMonth;
        switch (month.toLowerCase()) {
            case "enero" -> numberMonth = 1;
            case "febrero" -> numberMonth = 2;
            case "marzo" -> numberMonth = 3;
            case "abril" -> numberMonth = 4;
            case "mayo" -> numberMonth = 5;
            case "junio" -> numberMonth = 6;
            case "julio" -> numberMonth = 7;
            case "agosto" -> numberMonth = 8;
            case "septiembre" -> numberMonth = 9;
            case "octubre" -> numberMonth = 10;
            case "noviembre" -> numberMonth = 11;
            case "diciembre" -> numberMonth = 12;
            default -> throw new IllegalArgumentException("Mes inválido: " + month);
        }
        return numberMonth;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlRegisterBook.getBtnRegisterBook()) {
            verifyFields();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == pnlRegisterBook.getBtnRegisterBook()) {
            pnlRegisterBook.mouseEvent(pnlRegisterBook.getBtnRegisterBook(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == pnlRegisterBook.getBtnRegisterBook()) {
            pnlRegisterBook.mouseEvent(pnlRegisterBook.getBtnRegisterBook(), Utils.btnExited);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

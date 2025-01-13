package com.company.system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.company.system.model.Book;
import com.company.system.model.Loan;
import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.RegisterDevolution;
import com.company.system.view.RegisterLoan;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterDevolutionListener implements ActionListener, MouseListener, UtilsController {

    private final RegisterDevolution registerDevolution;
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;
    private final User librarian;
    private User student;
    private Book book;

    public RegisterDevolutionListener(User librarian, RegisterDevolution registerDevolution, BookService bookService,
            UserService userService, LoanService loanService) {
        this.librarian = librarian;
        this.registerDevolution = registerDevolution;
        this.bookService = bookService;
        this.userService = userService;
        this.loanService = loanService;
        addListeners();
    }

    private void addListeners() {
        registerDevolution.getBtnSearchIdCard().addActionListener(this);
        registerDevolution.getBtnRegisterDevolutio().addActionListener(this);
    }


    //Verifica la existencia y la validez del numero de cedula del estudiante buscado y lo agrega a la instancia student    
    private void searchIdCard() {
        Long idCard;
        try {
            idCard = Long.valueOf(registerDevolution.getTxtIdCardUser().getText());
            student = userService.getStudentByIdCard(idCard);
            if (student == null) {
                String error = "No se ha encontrado estudiante con el numero de cedula escrito";
                registerDevolution.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                registerDevolution.getLblNameStudent().setText(error);
                student = null;
            } else {
                registerDevolution.showMessage("Estudiante encontrado", "Estudiante encontrado!",
                        JOptionPane.INFORMATION_MESSAGE);
                registerDevolution.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());
            }
        } catch (NumberFormatException e1) {
            registerDevolution.showMessage("Escribe un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void uploadLoan() {
        List<Loan> loans = lo
    }

    //Verifica que los campos no esten vacios (incluyendo las instancias de book y studente) y que el formato de la fecha sea correcto
    //Verifica que el libro este disponible para prestamo
    //Verifica que el estudiante no tenga un prestamo sin devolver
    //Crea un nuevo prestamo
    private void registerLoan() {
        if (!isEmptyFields() && student != null && book != null) {
            try {
                Integer day = Integer.valueOf(pnlRegisterLoan.getTxtDay().getText());
                Integer year = Integer.valueOf(pnlRegisterLoan.getTxtYear().getText());

                if (isValidDate(day, (String) pnlRegisterLoan.getCmbMonth().getSelectedItem(), year)
                        && bookService.isAvailableToLoan(book)) {
                    LinkedList<Loan> userLoans = new LinkedList<>(loanService.getLoansByUser(student));
                    if (userLoans.isEmpty() || userLoans.getLast().isReturned()) {
                        loanService.createLoan(student, book,
                                getDate(day, (String) pnlRegisterLoan.getCmbMonth().getSelectedItem(), year),
                                librarian.getNames() + " " + librarian.getSurNames() + " ci: " + librarian.getIdCardUser());
                        pnlRegisterLoan.showMessage("Prestamo creado correctamente", "Nuevo prestamo", JOptionPane.INFORMATION_MESSAGE);
                        cleanFields();
                    } else {
                        pnlRegisterLoan.showMessage("No se puede registrar prestamo. El estudiante tiene un prestamo sin devolver", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    pnlRegisterLoan.showMessage("Escribe un formato de fecha correcto", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e1) {
                pnlRegisterLoan.showMessage("Escribe valores numericos en los campos de fecha", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            pnlRegisterLoan.showMessage("No pueden haber campos vacios, ni busquedas sin realizar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlRegisterLoan.getBtnSearchBook()) {
            if (!isEmptyFieldsBook()) {
                searchBook();
            } else {
                pnlRegisterLoan.showMessage("Escribe un ISBN", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == pnlRegisterLoan.getBtnSearchIdCard()) {
            if (!isEmptyFieldsUser()) {
                searchIdCard();
            } else {
                pnlRegisterLoan.showMessage("Escribe un numero de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == pnlRegisterLoan.getBtnRegisterLoan()) {
            if (!isEmptyFields()) {
                registerLoan();
            } else {
                pnlRegisterLoan.showMessage("No pueden haber campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == pnlRegisterLoan.getBtnClean()) {
            cleanFields();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == pnlRegisterLoan.getBtnSearchBook()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchBook(),
                    com.company.system.view.components.Utils.btnEntered);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchIdCard(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnRegisterLoan(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnClean(),
                    com.company.system.view.components.Utils.btnExited);

        } else if (e.getSource() == pnlRegisterLoan.getBtnSearchIdCard()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchBook(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchIdCard(),
                    com.company.system.view.components.Utils.btnEntered);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnRegisterLoan(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnClean(),
                    com.company.system.view.components.Utils.btnExited);

        } else if (e.getSource() == pnlRegisterLoan.getBtnRegisterLoan()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchBook(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchIdCard(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnRegisterLoan(),
                    com.company.system.view.components.Utils.btnEntered);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnClean(),
                    com.company.system.view.components.Utils.btnExited);
        } else if (e.getSource() == pnlRegisterLoan.getBtnClean()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchBook(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchIdCard(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnRegisterLoan(),
                    com.company.system.view.components.Utils.btnExited);
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnClean(),
                    com.company.system.view.components.Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == pnlRegisterLoan.getBtnSearchBook()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchBook(),
                    com.company.system.view.components.Utils.btnExited);
        } else if (e.getSource() == pnlRegisterLoan.getBtnSearchIdCard()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnSearchIdCard(),
                    com.company.system.view.components.Utils.btnExited);
        } else if (e.getSource() == pnlRegisterLoan.getBtnRegisterLoan()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnRegisterLoan(),
                    com.company.system.view.components.Utils.btnExited);
        } else if (e.getSource() == pnlRegisterLoan.getBtnClean()) {
            pnlRegisterLoan.changeColor(pnlRegisterLoan.getBtnClean(),
                    com.company.system.view.components.Utils.btnExited);
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

}

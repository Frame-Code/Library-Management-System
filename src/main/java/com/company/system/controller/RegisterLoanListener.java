package com.company.system.controller;

import com.company.system.model.Book;
import com.company.system.model.Loan;
import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.RegisterLoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterLoanListener implements ActionListener, Utils {

    private final RegisterLoan pnlRegisterLoan;
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;
    private final User librarian;
    private User student;
    private Book book;

    public RegisterLoanListener(User librarian, RegisterLoan pnlRegisterLoan, BookService bookService, UserService userService, LoanService loanService) {
        this.librarian = librarian;
        this.pnlRegisterLoan = pnlRegisterLoan;
        this.bookService = bookService;
        this.userService = userService;
        this.loanService = loanService;
        addListeners();
    }

    private void addListeners() {
        pnlRegisterLoan.getBtnSearchBook().addActionListener(this);
        pnlRegisterLoan.getBtnSearchIdCard().addActionListener(this);
        pnlRegisterLoan.getBtnRegisterLoan().addActionListener(this);
        pnlRegisterLoan.getBtnClean().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlRegisterLoan.getBtnSearchBook()) {
            book = bookService.getBookByISBN(pnlRegisterLoan.getTxtISBN().getText());
            if (book.getStockToLoan() < 0 || book == null) {
                String error = "No se ha encontrado un libro con el ISBN escrito o No existe stock del libro";
                pnlRegisterLoan.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                pnlRegisterLoan.getLblBookTittle().setText(error);
                book = null;

            } else {
                pnlRegisterLoan.showMessage("Libro se ha encontrado", "Libro encontrado!", JOptionPane.INFORMATION_MESSAGE);
                pnlRegisterLoan.getLblBookTittle().setText(book.getTitle());
            }

        } else if (e.getSource() == pnlRegisterLoan.getBtnSearchIdCard()) {
            Long idCard;
            try {
                idCard = Long.valueOf(pnlRegisterLoan.getTxtIdCardUser().getText());
                student = userService.getStudentByIdCard(idCard);
                if (student == null) {
                    String error = "No se ha encontrado estudiante con el numero de cedula escrito";
                    pnlRegisterLoan.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                    pnlRegisterLoan.getLblNameStudent().setText(error);
                    student = null;
                } else {
                    pnlRegisterLoan.showMessage("Estudiante encontrado", "Estudiante encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    pnlRegisterLoan.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());
                }
            } catch (NumberFormatException e1) {
                pnlRegisterLoan.showMessage("Escribe un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (e.getSource() == pnlRegisterLoan.getBtnRegisterLoan()) {
            if (!pnlRegisterLoan.getTxtISBN().getText().isEmpty() && !pnlRegisterLoan.getTxtIdCardUser().getText().isEmpty()
                    && !pnlRegisterLoan.getTxtDay().getText().isEmpty() && !pnlRegisterLoan.getTxtYear().getText().isEmpty()
                    && student != null && book != null) {
                try {
                    Integer day = Integer.valueOf(pnlRegisterLoan.getTxtDay().getText());
                    Integer year = Integer.valueOf(pnlRegisterLoan.getTxtYear().getText());

                    if (day > 31 || day < 0 || day < LocalDate.now().getDayOfMonth() || 
                            year < LocalDate.now().getYear() || year > (LocalDate.now().getYear() + 4)) {
                        pnlRegisterLoan.showMessage("Escribe un formato de fecha correcto", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        LinkedList<Loan> userLoans = new LinkedList<>(loanService.getLoansByUser(student));
                        if (userLoans.getLast().isReturned() && getDate(day, (String) pnlRegisterLoan.getCmbMonth().getSelectedItem(), year).isAfter(LocalDate.now())) {
                            loanService.createLoan(student, book, 
                        getDate(day, (String) pnlRegisterLoan.getCmbMonth().getSelectedItem(), year),
                                    librarian.getNames() + " " + librarian.getSurNames() + " ci: " + librarian.getIdCardUser());
                            pnlRegisterLoan.showMessage("Prestamo creado correctamente", "Nuevo prestamo", JOptionPane.INFORMATION_MESSAGE);
                            student = null;
                            book = null;
                            pnlRegisterLoan.getTxtISBN().setText("");
                            pnlRegisterLoan.getTxtIdCardUser().setText("");
                            pnlRegisterLoan.getTxtDay().setText("");
                            pnlRegisterLoan.getTxtYear().setText("");
                            pnlRegisterLoan.getLblNameStudent().setText("");
                            pnlRegisterLoan.getLblBookTittle().setText("");
                        }
                    }

                } catch (NumberFormatException e1) {
                    pnlRegisterLoan.showMessage("Escribe valores numericos en los campos de fecha", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                pnlRegisterLoan.showMessage("No pueden haber campos vacios, ni busquedas sin realizar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

package com.company.system.controller;

import com.company.system.model.Book;
import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.UserService;
import com.company.system.view.RegisterLoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterLoanListener implements ActionListener {

    private final RegisterLoan pnlRegisterLoan;
    private final BookService bookService;
    private final UserService userService;

    public RegisterLoanListener(RegisterLoan pnlRegisterLoan, BookService bookService, UserService userService) {
        this.pnlRegisterLoan = pnlRegisterLoan;
        this.bookService = bookService;
        this.userService = userService;
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
            Book book = bookService.getBookByISBN(pnlRegisterLoan.getTxtISBN().getText());
            if (book.getStock() < 0 || book == null) {
                String error = "No se ha encontrado un libro con el ISBN escrito o No existe stock del libro";
                pnlRegisterLoan.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                pnlRegisterLoan.getLblBookTittle().setText(error);

            } else {
                pnlRegisterLoan.showMessage("Libro se ha encontrado", "Libro encontrado!", JOptionPane.INFORMATION_MESSAGE);
                pnlRegisterLoan.getLblBookTittle().setText(book.getTitle());
            }

        } else if (e.getSource() == pnlRegisterLoan.getBtnSearchIdCard()) {
            Long idCard;
            try {
                idCard = Long.valueOf(pnlRegisterLoan.getTxtIdCardUser().getText());
                User user = userService.getStudentByIdCard(idCard);
                if (user == null) {
                    String error = "No se ha encontrado estudiante con el numero de cedula escrito";
                    pnlRegisterLoan.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                    pnlRegisterLoan.getLblNameStudent().setText(error);
                } else {
                    pnlRegisterLoan.showMessage("Estudiante encontrado", "Estudiante encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    pnlRegisterLoan.getLblNameStudent().setText(user.getNames() + " " + user.getSurNames());
                }
            } catch (NumberFormatException e1) {
                pnlRegisterLoan.showMessage("Escribe un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

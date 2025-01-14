package com.company.system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.company.system.model.Loan;
import com.company.system.model.User;
import com.company.system.service.DevolutionService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.RegisterDevolution;


/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterDevolutionListener implements ActionListener {

    private final RegisterDevolution registerDevolution;
    private final UserService userService;
    private final LoanService loanService;
    private final DevolutionService devolutionService;
    private final User librarian;
    private LinkedList<Loan> loans;
    private User student;

    public RegisterDevolutionListener(User librarian, RegisterDevolution registerDevolution, LoanService loanService, UserService userService) {
        this.librarian = librarian;
        this.registerDevolution = registerDevolution;
        this.devolutionService = new DevolutionService();
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
        loans = new LinkedList<>(loanService.getLoansByUser(student));
        if(loans != null && loans.getLast().getDevolution() == null) {
            registerDevolution.getTxtAreaInfoLoan().append(
                    "Libro prestado: " + loans.getLast().getBook().getTitle() + "\n" +
                    "ISBN: " + loans.getLast().getBook().getIsbn() + "\n" +
                    "Fecha devolucion esperada: " + loans.getLast().getDevolutionDate() + "\n" +
                    "Fecha de prestamo: " + loans.getLast().getRegistrationDate().toString() + "\n" +
                    "Ha solicitado prorroga?: " + ((loans.getLast().getRegistrationDate() != null)? "No" : "Si") + "\n" +
                    "Fecha de registro de prorroga: " + ((loans.getLast().getRegistrationDate() != null)? "----" : loans.getLast().getRegistrationUpdateDate().toString()) + "\n" +
                    "Ha sido devuelto? " + ((loans.getLast().isReturned())? "Si" : "No")
            );
        } else {
            registerDevolution.getTxtAreaInfoLoan().setText("El estudiante no tiene un libro registrado disponible para devolucion");
        }
    }
    
    private void registerDevolution() {
        if (student != null && loans.getLast().getDevolution() == null) {
            devolutionService.registerDevolution(loans.getLast(), librarian);
            registerDevolution.showMessage("Devolucion registrada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            registerDevolution.showMessage("No pueden haber campos vacios, o el usario ya registrado una devolucion del su ultimo libro", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerDevolution.getBtnSearchIdCard()) {
            searchIdCard();
            uploadLoan();
        } else if(e.getSource() == registerDevolution.getBtnRegisterDevolutio()) {
            registerDevolution();
        }
    }
}
package com.company.system.controller;

import com.company.system.model.User;
import com.company.system.service.FineService;
import com.company.system.service.UserService;
import com.company.system.view.RegisterFine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterFineListener implements ActionListener, MouseListener, UtilsController {

    private RegisterFine registerFine;
    private UserService userService;
    private FineService fineService;
    private LocalDate deadeline;
    private User student;
    private User librarian;

    public RegisterFineListener(RegisterFine registerFine, User librarian, UserService userService, FineService fineService) {
        this.registerFine = registerFine;
        this.librarian = librarian;
        this.userService = userService;
        this.fineService = fineService;
        addListeners();
    }

    private void addListeners() {
        registerFine.getBtnSearchIdCard().addActionListener(this);
        registerFine.getBtnRegisterLoan().addActionListener(this);
        registerFine.getBtnClean().addActionListener(this);
        
        registerFine.getBtnSearchIdCard().addMouseListener(this);
        registerFine.getBtnRegisterLoan().addMouseListener(this);
        registerFine.getBtnClean().addMouseListener(this);
    }

    private boolean isAvailableToRegister() {
        return !registerFine.getTxtIdCardUser().getText().equals("") && !registerFine.getTxtDay().getText().equals("")
                && !registerFine.getTxtYear().getText().equals("") && !registerFine.getAreaMessage().getText().equals("")
                && student != null;
    }

    private boolean isValidDate() {
        try {
            int day = Integer.parseInt(registerFine.getTxtDay().getText());
            int year = Integer.parseInt(registerFine.getTxtYear().getText());
            String month = (String) registerFine.getCmbMonth().getSelectedItem();
            if (day <= 31 && day >= 0 && year >= LocalDate.now().getYear() && year < (LocalDate.now().getYear() + 4) && getDate(day, month, year).isAfter(LocalDate.now())) {
                deadeline = getDate(day, month, year);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void cleanFields() {
        registerFine.getTxtIdCardUser().setText("");
        registerFine.getTxtDay().setText("");
        registerFine.getTxtYear().setText("");
        registerFine.getAreaMessage().setText("");
        student = null;
        deadeline = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (registerFine.getBtnSearchIdCard() == e.getSource()) {
            try {
                Long idCard = Long.parseLong(registerFine.getTxtIdCardUser().getText());
                student = userService.getStudentByIdCard(idCard);
                registerFine.getLblNameStudent().setText(student.getFullNames());
                registerFine.showMessage("Estudiante encontrado correctamente", "Estudiante encontrado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                registerFine.showMessage("Escribe correctamente el numero de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (registerFine.getBtnRegisterLoan() == e.getSource()) {
            if (isAvailableToRegister() && isValidDate()) {
                fineService.register(student, deadeline, registerFine.getAreaMessage().getText(), librarian.getFullNames());
                registerFine.showMessage("Multa registrada correctamente", "Multa registrada", JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
            } else {
                registerFine.showMessage("Escribe correctamente los campos necesarios o busca el estudiante correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (registerFine.getBtnClean() == e.getSource()) {
            cleanFields();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == registerFine.getBtnSearchIdCard()) {
            registerFine.getBtnSearchIdCard().setBackground(btnEntered);
            registerFine.getBtnRegisterLoan().setBackground(btnExited);
            registerFine.getBtnClean().setBackground(btnExited);
        } else if (e.getSource() == registerFine.getBtnRegisterLoan()) {
            registerFine.getBtnSearchIdCard().setBackground(btnExited);
            registerFine.getBtnRegisterLoan().setBackground(btnEntered);
            registerFine.getBtnClean().setBackground(btnExited);
        } else if (e.getSource() == registerFine.getBtnClean()) {
            registerFine.getBtnSearchIdCard().setBackground(btnExited);
            registerFine.getBtnRegisterLoan().setBackground(btnExited);
            registerFine.getBtnClean().setBackground(btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == registerFine.getBtnSearchIdCard()) {
            registerFine.getBtnSearchIdCard().setBackground(btnExited);
        } else if (e.getSource() == registerFine.getBtnRegisterLoan()) {
            registerFine.getBtnRegisterLoan().setBackground(btnExited);
        } else if (e.getSource() == registerFine.getBtnClean()) {
            registerFine.getBtnClean().setBackground(btnExited);
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

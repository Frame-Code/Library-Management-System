package com.company.system.controller;

import com.company.system.model.User;
import com.company.system.service.UserService;
import com.company.system.view.RegisterFine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegisterFineListener implements ActionListener {

    private RegisterFine registerFine;
    private UserService userService;
    private User student;

    public RegisterFineListener(RegisterFine registerFine) {
        this.registerFine = registerFine;
        this.userService = new UserService();
        addListeners();
    }

    private void addListeners() {
        registerFine.getBtnSearchIdCard().addActionListener(this);
        registerFine.getBtnRegisterLoan().addActionListener(this);
        registerFine.getBtnClean().addActionListener(this);
    }

    private boolean isAvailableToRegister() {
        return !registerFine.getTxtIdCardUser().getText().equals("") && !registerFine.getTxtDay().getText().equals("")
                && !registerFine.getTxtYear().getText().equals("") && !registerFine.getAreaMessage().getText().equals("")
                && student != null;
    }

    private void cleanFields() {
        registerFine.getTxtIdCardUser().setText("");
        registerFine.getTxtDay().setText("");
        registerFine.getTxtYear().setText("");
        registerFine.getAreaMessage().setRows(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (registerFine.getBtnSearchIdCard() == e.getSource()) {
            System.out.println("Entro al boton del register");
            try {
                Long idCard = Long.parseLong(registerFine.getTxtIdCardUser().getText());
                student = userService.getStudentByIdCard(idCard);
                registerFine.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());
                registerFine.showMessage("Estudiante encontrado correctamente", "Estudiante encontrado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                registerFine.showMessage("Escribe correctamente el numero de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (registerFine.getBtnRegisterLoan() == e.getSource()) {
            if (isAvailableToRegister()) {

            } else {
                registerFine.showMessage("No pueden haber campos vacios ni estudiantes sin buscar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (registerFine.getBtnClean() == e.getSource()) {
            cleanFields();
        }
    }
}

package com.company.system.controller;

import com.company.system.service.UserService;
import com.company.system.view.RegisterStudent;
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
 * @author Joel Pazmiño
 */
public class RegisterStudentListener implements ActionListener, MouseListener, KeyListener {

    private final RegisterStudent frmRegisterStudent;
    private final UserService userService;

    public RegisterStudentListener(RegisterStudent frmRegisterStudent) {
        this.frmRegisterStudent = frmRegisterStudent;
        this.userService = new UserService();
        addListener();
    }

    private void addListener() {
        frmRegisterStudent.getBtnBackRegister().addActionListener(this);
        frmRegisterStudent.getBtnBackRegister().addMouseListener(this);
        frmRegisterStudent.getBtnBackRegister().addKeyListener(this);
        frmRegisterStudent.getBtnRegister().addActionListener(this);
        frmRegisterStudent.getBtnRegister().addMouseListener(this);
    }

    private void verifyFields() {
        try {
            String names = frmRegisterStudent.getTxtNames().getText();
            String surNames = frmRegisterStudent.getTxtSurnames().getText();
            String email = frmRegisterStudent.getTxtEmail().getText();
            Long idCard = Long.valueOf(frmRegisterStudent.getTxtId().getText());
            String passwordPlain = new String(frmRegisterStudent.getPswPassword().getPassword());
            String confirmPassword = new String(frmRegisterStudent.getPswConfirmPassword().getPassword());
            LocalDate birthDate = LocalDate.of(
                    Integer.parseInt(frmRegisterStudent.getTxtYear().getText()),
                    Integer.parseInt(frmRegisterStudent.getCmbMonth().getSelectedItem().toString()),
                    Integer.parseInt(frmRegisterStudent.getTxtDay().getText())
            );

            // Validación de campos vacíos
            if (names.isEmpty() || surNames.isEmpty() || email.isEmpty() || passwordPlain.isEmpty() || confirmPassword.isEmpty()) {
                frmRegisterStudent.errorMessage(frmRegisterStudent.errorEmptyFields);
                return;
            }

            // Validación de contraseñas
            if (!passwordPlain.equals(confirmPassword)) {
                frmRegisterStudent.errorMessage("Las contraseñas no coinciden.");
                return;
            }

            // Verificar disponibilidad del correo e identificación
            if (!userService.isAvailableEmail(email)) {
                frmRegisterStudent.errorMessage("El correo ya está en uso.");
                return;
            }
            if (!userService.isAvailableIdCard(idCard)) {
                frmRegisterStudent.errorMessage("La identificación ya está en uso.");
                return;
            }

            // Registro del estudiante
            boolean registered = userService.RegisterStudent(names, surNames, email, idCard, birthDate, passwordPlain);
            if (registered) {
                frmRegisterStudent.successMessage("Estudiante registrado exitosamente.");
            } else {
                frmRegisterStudent.errorMessage("Ocurrió un error al registrar al estudiante.");
            }
            
        } catch (Exception ex) {
            frmRegisterStudent.errorMessage("Ocurrió un error inesperado: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.back();
            frmRegisterStudent.close();
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            verifyFields();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnEntered);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegister(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnExited);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegister(), Utils.btnExited);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            verifyFields();
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
    public void keyReleased(KeyEvent e) {
    }

}

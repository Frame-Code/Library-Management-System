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

    // Atributos privados que hacen referencia al formulario de registro y al servicio de usuarios
    private final RegisterStudent frmRegisterStudent;
    private final UserService userService;

    // Constructor que recibe el formulario y el servicio de usuarios
    public RegisterStudentListener(RegisterStudent frmRegisterStudent, UserService userService) {
        this.frmRegisterStudent = frmRegisterStudent;
        this.userService = userService;
        addListener(); // Agrega los oyentes de eventos a los botones
    }

    // Método para agregar los oyentes de eventos a los botones del formulario
    private void addListener() {
        // Añade los escuchadores de eventos para los botones de registro y retroceder
        frmRegisterStudent.getBtnBackRegister().addActionListener(this);
        frmRegisterStudent.getBtnBackRegister().addMouseListener(this);
        frmRegisterStudent.getBtnBackRegister().addKeyListener(this);
        frmRegisterStudent.getBtnRegister().addActionListener(this);
        frmRegisterStudent.getBtnRegister().addMouseListener(this);
    }

    // Método para verificar los campos del formulario y realizar el registro
    private void verifyFields() {
        try {
            // Obtiene los valores de los campos del formulario
            String names = frmRegisterStudent.getTxtNames().getText();
            String surNames = frmRegisterStudent.getTxtSurnames().getText();
            String email = frmRegisterStudent.getTxtEmail().getText();
            String idCardText = frmRegisterStudent.getTxtId().getText();
            String passwordPlain = new String(frmRegisterStudent.getPswPassword().getPassword());
            String confirmPassword = new String(frmRegisterStudent.getPswConfirmPassword().getPassword());
            String yearText = frmRegisterStudent.getTxtYear().getText();
            String monthText = frmRegisterStudent.getCmbMonth().getSelectedItem().toString();
            String dayText = frmRegisterStudent.getTxtDay().getText();

            // Validación de campos vacíos
            if (names.isEmpty() || surNames.isEmpty() || email.isEmpty() || idCardText.isEmpty()
                    || passwordPlain.isEmpty() || confirmPassword.isEmpty()
                    || yearText.isEmpty() || monthText.isEmpty() || dayText.isEmpty()) {
                frmRegisterStudent.errorMessage(frmRegisterStudent.errorEmptyFields); // Muestra mensaje si algún campo está vacío
                return;
            }

            // Validación de contraseñas
            if (!passwordPlain.equals(confirmPassword)) {
                frmRegisterStudent.errorMessage("Las contraseñas no coinciden."); // Muestra mensaje si las contraseñas no coinciden
                return;
            }

            // Validación de los datos numéricos
            try {
                Long idCard = Long.valueOf(idCardText);
                int year = Integer.parseInt(yearText);
                int month = convertNumber(monthText); // Convierte el mes en número
                int day = Integer.parseInt(dayText);
                LocalDate birthDate = LocalDate.of(year, month, day); // Crea la fecha de nacimiento

                // Verifica si el correo y la identificación están disponibles
                if (!userService.isAvailableEmail(email)) {
                    frmRegisterStudent.errorMessage("El correo ya está en uso.");
                    return;
                }
                if (!userService.isAvailableIdCard(idCard)) {
                    frmRegisterStudent.errorMessage("La identificación ya está en uso.");
                    return;
                }

                // Registra al estudiante en el sistema
                boolean registered = userService.RegisterStudent(names, surNames, email, idCard, birthDate, passwordPlain);
                if (registered) {
                    frmRegisterStudent.successMessage("Estudiante registrado exitosamente.");
                } else {
                    frmRegisterStudent.errorMessage("Ocurrió un error al registrar al estudiante.");
                }
            } catch (NumberFormatException ex) {
                frmRegisterStudent.errorMessage("Por favor ingresa valores numéricos válidos para la identificación y la fecha.");
            }

        } catch (Exception ex) {
            frmRegisterStudent.errorMessage("Ocurrió un error inesperado: " + ex.getMessage());
        }
    }

    // Método para convertir el nombre del mes a su correspondiente número
    private int convertNumber(String mes) {
        int numberMonth;
        switch (mes.toLowerCase()) {
            case "enero" ->
                numberMonth = 1;
            case "febrero" ->
                numberMonth = 2;
            case "marzo" ->
                numberMonth = 3;
            case "abril" ->
                numberMonth = 4;
            case "mayo" ->
                numberMonth = 5;
            case "junio" ->
                numberMonth = 6;
            case "julio" ->
                numberMonth = 7;
            case "agosto" ->
                numberMonth = 8;
            case "septiembre" ->
                numberMonth = 9;
            case "octubre" ->
                numberMonth = 10;
            case "noviembre" ->
                numberMonth = 11;
            case "diciembre" ->
                numberMonth = 12;
            default ->
                throw new IllegalArgumentException("Mes inválido: " + mes);
        }
        return numberMonth;
    }

    // Método para manejar los eventos de acción (clic en los botones)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            // Si se hace clic en el botón de retroceder, vuelve a la ventana anterior y cierra la actual
            frmRegisterStudent.back(userService);
            frmRegisterStudent.close();
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            // Si se hace clic en el botón de registro, verifica los campos antes de proceder
            verifyFields();
        }
    }

    // Método para manejar el evento cuando el ratón entra en un componente
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnEntered);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegister(), Utils.btnEntered);
        }
    }

    // Método para manejar el evento cuando el ratón sale de un componente
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnExited);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegister(), Utils.btnExited);
        }
    }

    // Método para manejar el evento cuando se presiona una tecla
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Si se presiona la tecla Enter, verifica los campos antes de proceder
            verifyFields();
        }
    }

    // Métodos de MouseListener que no realizan ninguna acción, pero deben ser implementados
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // Métodos de KeyListener que no realizan ninguna acción, pero deben ser implementados
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

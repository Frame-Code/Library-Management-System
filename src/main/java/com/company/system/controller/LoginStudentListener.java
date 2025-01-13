package com.company.system.controller;

import com.company.system.service.UserService;
import com.company.system.view.LoginStudent;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Joel Pazmiño
 */
public class LoginStudentListener implements ActionListener, MouseListener, KeyListener {

    // Atributos privados que referencian al formulario y al servicio de usuarios
    private final LoginStudent frmLogin;
    private final UserService userService;

    // Constructor de la clase, recibe el formulario y el servicio de usuarios
    public LoginStudentListener(LoginStudent frmLogin, UserService userService) {
        this.frmLogin = frmLogin;
        this.userService = userService;
        addListeners(); // Agrega los oyentes de eventos a los componentes del formulario
    }

    // Método para agregar los oyentes a los componentes del formulario
    private void addListeners() {
        // Añade los escuchadores de eventos para los botones de login, retroceder y registrar
        frmLogin.getBtnLogin().addActionListener(this);
        frmLogin.getBtnLogin().addMouseListener(this);
        frmLogin.getBtnLogin().addKeyListener(this);
        frmLogin.getBtnBack().addActionListener(this);
        frmLogin.getBtnBack().addMouseListener(this);
        frmLogin.getBtnRegister().addActionListener(this);
        frmLogin.getBtnRegister().addMouseListener(this);
    }

    // Método para verificar si el login es válido
    private void verifyLogin() {
        try {
            // Obtiene el ID del usuario desde el formulario
            Long idUser = Long.valueOf(frmLogin.getTxtIdCard().getText());

            // Verifica si el estudiante existe en el sistema
            if (userService.studentExists(idUser)) {
                String plainPassword = "";
                // Convierte la contraseña del usuario de char[] a String
                for (char p : frmLogin.getPswUser().getPassword()) {
                    plainPassword += p;
                }

                // Verifica si las credenciales son correctas
                if (userService.login(idUser, plainPassword) != null) {
                    // Si las credenciales son correctas, abre la ventana principal y cierra la actual
                    frmLogin.openLibraryHome(userService.getLoggedUser(idUser), userService);
                    frmLogin.close();
                } else {
                    // Si la contraseña es incorrecta, muestra un mensaje de error
                    frmLogin.errorMessage(frmLogin.errorIncorrectPassword);
                }
            } else {
                // Si el estudiante no existe, muestra un mensaje de error
                frmLogin.errorMessage(frmLogin.errorUserExists);
            }
        } catch (NumberFormatException ex) {
            // Si el formato del ID es incorrecto, muestra un mensaje de error
            frmLogin.errorMessage(frmLogin.errorFormatId);
        }
    }

    // Método para verificar si los campos de entrada no están vacíos antes de proceder con el login
    private void verifyFields() {
        if (!frmLogin.getTxtIdCard().getText().equals("") && frmLogin.getPswUser().getPassword().length != 0) {
            verifyLogin(); // Si los campos no están vacíos, verifica el login
        } else {
            // Si algún campo está vacío, muestra un mensaje de error
            frmLogin.errorMessage(frmLogin.errorEmptyFields);
        }
    }

    // Método que maneja los eventos de acción (clic en los botones)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.getBtnBack()) {
            // Si se hace clic en el botón de retroceder, se ejecuta la acción correspondiente
            frmLogin.back(userService);
        } else if (e.getSource() == frmLogin.getBtnLogin()) {
            // Si se hace clic en el botón de login, verifica los campos antes de proceder
            verifyFields();
        } else if (e.getSource() == frmLogin.getBtnRegister()) {
            // Si se hace clic en el botón de registro, abre la ventana de registro
            frmLogin.openRegisterWindow(userService);
            frmLogin.close(); // Cierra la ventana actual
        }
    }

    // Método que maneja el evento cuando el ratón entra en un componente
    @Override
    public void mouseEntered(MouseEvent e) {
        // Cambia el color del botón cuando el ratón entra en él
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.mouseEvent(frmLogin.getBtnBack(), Utils.btnEntered);
        } else if (e.getSource() == frmLogin.getBtnLogin()) {
            frmLogin.mouseEvent(frmLogin.getBtnLogin(), Utils.btnEntered);
        } else if (e.getSource() == frmLogin.getBtnRegister()) {
            frmLogin.mouseEvent(frmLogin.getBtnRegister(), Utils.btnEntered);
        }
    }

    // Método que maneja el evento cuando el ratón sale de un componente
    @Override
    public void mouseExited(MouseEvent e) {
        // Cambia el color del botón cuando el ratón sale de él
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.mouseEvent(frmLogin.getBtnBack(), Utils.btnExited);
        } else if (e.getSource() == frmLogin.getBtnLogin()) {
            frmLogin.mouseEvent(frmLogin.getBtnLogin(), Utils.btnExited);
        } else if (e.getSource() == frmLogin.getBtnRegister()) {
            frmLogin.mouseEvent(frmLogin.getBtnRegister(), Utils.btnExited);
        }
    }

    // Método que maneja el evento cuando se presiona una tecla
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

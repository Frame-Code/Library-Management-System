package com.company.system.controller;

import com.company.system.service.UserService;
import com.company.system.view.LoginLibrarian;
import com.company.system.view.components.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase es contiene todos los listeners necesarios para el funcionamiento
 * de la ventana llamada "LoginLibrarian" dentro del paquete view
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoginLibrarianListener implements ActionListener, MouseListener, KeyListener {

    private final LoginLibrarian frmLoginLibrarian;
    private final UserService userService;

    public LoginLibrarianListener(LoginLibrarian frmLoginLibrarian, UserService userService) {
        this.frmLoginLibrarian = frmLoginLibrarian;
        this.userService = userService;
        addListeners();
    }

    //Agrega escuchadores de eventos a cada componente de la ventana que lo necestia 
    private void addListeners() {
        frmLoginLibrarian.getBtnBack().addActionListener(this);
        frmLoginLibrarian.getBtnBack().addMouseListener(this);
        frmLoginLibrarian.getBtnLogin().addActionListener(this);
        frmLoginLibrarian.getBtnLogin().addMouseListener(this);
        frmLoginLibrarian.getBtnLogin().addKeyListener(this);
    }

    /**
     * Este metodo hace las verificaciones necesarias (dentro de lo que le
     * conscierne a este paquete) Para generar un login exitoso, entre las
     * comprobaciones estam: - Verificar que el valor ingresado por el campo
     * cedula es numero - Llamar a la logica de negocio (userService) para que
     * retorne si el usuario existe o no - Llamar a la logica de negocio
     * (userService) para que retorne si la contraseña fue correcta En el caso
     * de que algunas de estas comprobaciones salen erroneas, se pasa a la vista
     * para que haga muestre aquello
     */
    private void verifyLogin() {
        try {
            Long idUser = Long.valueOf(frmLoginLibrarian.getTxtIdUser().getText());
            if (userService.librarianExists(idUser)) {
                String plainPassword = "";
                for (char p : frmLoginLibrarian.getPswUser().getPassword()) {
                    plainPassword += p;
                }

                if (userService.login(idUser, plainPassword) != null) {
                    frmLoginLibrarian.login();
                } else {
                    frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorIncorrectPassword);
                }
            } else {
                frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorUserExists);
            }
        } catch (NumberFormatException ex) {
            frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorFormatId);
        }
    }

    //Este metodo verifica que los campos de login no esten vacios
    private void verifyFields() {
        if (!frmLoginLibrarian.getTxtIdUser().getText().equals("")
                && frmLoginLibrarian.getPswUser().getPassword().length != 0) {
            verifyLogin();
        } else {
            frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorEmptyFields);
        }
    }

    //Escuchador de eventos del click de los dos botones que tiene la ventana
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.back(userService);
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            verifyFields();
        }
    }

    //Escuchador de evento de los dos botones que tiene la ventana para cambiar color cuando el puntero esta sobre el bton
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnBack(), Utils.btnEntered);
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnLogin(), Utils.btnEntered);
        }
    }

    //Escuchador de evento de los dos botones que tiene la ventana para cambiar color cuando el puntero sale del btn
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnBack(), Utils.btnExited);
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnLogin(), Utils.btnExited);
        }
    }

    //Escuchador de evento en el caso que se presione la tecla Ok o Enter del teclado
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            verifyFields();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Este método se llama cuando se hace clic en un componente con el ratón.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este método se llama cuando se presiona un botón del ratón sobre un componente.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este método se llama cuando se libera el botón del ratón después de presionarlo.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método se llama cuando se ingresa un carácter (cuando se presiona una tecla que produce un carácter).
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Este método se llama cuando se suelta una tecla.
        // Actualmente no se implementa ninguna acción específica.
    }

}

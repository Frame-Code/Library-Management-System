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
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoginLibrarianListener implements ActionListener, MouseListener, KeyListener {

    private final LoginLibrarian frmLoginLibrarian;
    private final UserService userService;

    public LoginLibrarianListener(LoginLibrarian frmLoginLibrarian) {
        this.frmLoginLibrarian = frmLoginLibrarian;
        this.userService = new UserService();
        addListeners();
    }

    private void addListeners() {
        frmLoginLibrarian.getBtnBack().addActionListener(this);
        frmLoginLibrarian.getBtnBack().addMouseListener(this);
        frmLoginLibrarian.getBtnLogin().addActionListener(this);
        frmLoginLibrarian.getBtnLogin().addMouseListener(this);
        frmLoginLibrarian.getBtnLogin().addKeyListener(this);
    }

    private void verifyLogin() {
        try {
            Long idUser = Long.valueOf(frmLoginLibrarian.getTxtIdUser().getText());
            if(userService.librarianExists(idUser)) {
                String plainPassword = "";
                for (char p : frmLoginLibrarian.getPswUser().getPassword()) {
                    plainPassword += p;
                }

                if(userService.login(idUser, plainPassword) != null) {
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

    private void verifyFields() {
        if (!frmLoginLibrarian.getTxtIdUser().getText().equals("") && 
        frmLoginLibrarian.getPswUser().getPassword().length != 0) {
            verifyLogin();
        } else {
            frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorEmptyFields);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.back();
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            verifyFields();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnBack(), Utils.btnEntered);
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnLogin(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnBack(), Utils.btnExited);
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseEvent(frmLoginLibrarian.getBtnLogin(), Utils.btnExited);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
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

package com.company.system.controller;

import com.company.system.service.UserService;
import com.company.system.view.LoginLibrarian;
import com.company.system.view.components.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoginLibrarianListener implements ActionListener, MouseListener {

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.back();
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {

            if (!frmLoginLibrarian.getTxtIdUser().getText().equals("")) {
                if (frmLoginLibrarian.getPswUser().getPassword().length != 0) {
                    try {
                        Long idUser = Long.valueOf(frmLoginLibrarian.getTxtIdUser().getText());
                        if(userService.userExists(idUser)) {
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
                } else {
                    frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorPasswordEmpty);
                }
            } else {
                frmLoginLibrarian.errorMessage(frmLoginLibrarian.errorEmptyFields);
            }

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
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

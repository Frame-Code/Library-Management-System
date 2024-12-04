package com.company.system.controller;

import com.company.system.view.LoginLibrarian;
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

    public LoginLibrarianListener(LoginLibrarian frmLoginLibrarian) {
        this.frmLoginLibrarian = frmLoginLibrarian;
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
                        //Pasar a service
                    } catch (NumberFormatException ex) {
                        frmLoginLibrarian.errorFormatIdUser();
                    }
                } else {
                    frmLoginLibrarian.errorPasswordEmpty();
                }
            } else {
                frmLoginLibrarian.errorEmpyFields();
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseEntered(frmLoginLibrarian.getBtnBack());
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseEntered(frmLoginLibrarian.getBtnLogin());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLoginLibrarian.getBtnBack()) {
            frmLoginLibrarian.mouseExited(frmLoginLibrarian.getBtnBack());
        } else if (e.getSource() == frmLoginLibrarian.getBtnLogin()) {
            frmLoginLibrarian.mouseExited(frmLoginLibrarian.getBtnLogin());
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

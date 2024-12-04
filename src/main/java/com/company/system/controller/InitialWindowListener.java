package com.company.system.controller;

import com.company.system.view.InitialWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class InitialWindowListener implements ActionListener, MouseListener {

    private final InitialWindow frmInitial;

    public InitialWindowListener(InitialWindow frmInitial) {
        this.frmInitial = frmInitial;
        addListeners();
    }

    private void addListeners() {
        frmInitial.getBtnLibrarianLogin().addActionListener(this);
        frmInitial.getBtnLibrarianLogin().addMouseListener(this);
        frmInitial.getBtnStudentLogin().addActionListener(this);
        frmInitial.getBtnStudentLogin().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {

        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.openLoginLibrarian();
            frmInitial.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {
            frmInitial.mouseEntered(frmInitial.getBtnStudentLogin());
        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.mouseEntered(frmInitial.getBtnLibrarianLogin());
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {
            frmInitial.mouseExited(frmInitial.getBtnStudentLogin());
        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.mouseExited(frmInitial.getBtnLibrarianLogin());
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

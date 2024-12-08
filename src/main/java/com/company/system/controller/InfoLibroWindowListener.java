package com.company.system.controller;

import com.company.system.view.InfoLibroWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author  Ariel Reyes Domo
 */
public class InfoLibroWindowListener implements ActionListener, MouseListener {

    private final InfoLibroWindow frmLibrowindow;

    public InfoLibroWindowListener(InfoLibroWindow frmLibrowindow) {
        this.frmLibrowindow = frmLibrowindow;
        addListeners();
    }

    private void addListeners() {
        frmLibrowindow.getBtnNotify().addActionListener(this);
        frmLibrowindow.getBtnNotify().addMouseListener(this);
        frmLibrowindow.getBtnBack().addActionListener(this);
        frmLibrowindow.getBtnBack().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            //-----//
        } else if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getBtnNotify());
        } else if(e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getBtnBack());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getBtnNotify());
        } else if(e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getBtnBack());
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

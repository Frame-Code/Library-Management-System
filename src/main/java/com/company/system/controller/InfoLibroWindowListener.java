package com.company.system.controller;

import com.company.system.view.InfoLibroWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author  Ariel Reyes
 */
public class InfoLibroWindowListener implements ActionListener, MouseListener {

    private final InfoLibroWindow frmLibrowindow;

    public InfoLibroWindowListener(InfoLibroWindow frmLibrowindow) {
        this.frmLibrowindow = frmLibrowindow;
        addListeners();
    }

    private void addListeners() {
       
        frmLibrowindow.getbtnNotificacion().addActionListener(this);
        frmLibrowindow.getbtnNotificacion().addMouseListener(this);
        frmLibrowindow.getbtnatras().addActionListener(this);
        frmLibrowindow.getbtnatras().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLibrowindow.getbtnNotificacion()) {

        } else if (e.getSource() == frmLibrowindow.getbtnNotificacion()) {
            frmLibrowindow.openLoginLibrarian();
            frmLibrowindow.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (e.getSource() == frmLibrowindow.getbtnNotificacion()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getbtnNotificacion());
        } else if(e.getSource() == frmLibrowindow.getbtnatras()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getbtnatras());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getbtnNotificacion()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getbtnNotificacion());
        } else if(e.getSource() == frmLibrowindow.getbtnatras()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getbtnatras());
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

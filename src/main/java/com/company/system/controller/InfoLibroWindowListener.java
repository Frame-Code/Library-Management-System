package com.company.system.controller;

import com.company.system.view.InfoLibroWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author artist-code (Ariel Reyes )
 */
public class InfoLibroWindowListener implements ActionListener, MouseListener {

    private final InfoLibroWindow frmInitial;

    public InfoLibroWindowListener(InfoLibroWindow frmInitial) {
        this.frmInitial = frmInitial;
        addListeners();
    }

    private void addListeners() {
        frmInitial.getbtnReservaLibro().addActionListener(this);
        frmInitial.getbtnReservaLibro().addMouseListener(this);
        frmInitial.getbtnNotificacion().addActionListener(this);
        frmInitial.getbtnNotificacion().addMouseListener(this);
        frmInitial.getbtnatras().addActionListener(this);
        frmInitial.getbtnatras().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInitial.getbtnReservaLibro()) {

        } else if (e.getSource() == frmInitial.getbtnReservaLibro()) {
            frmInitial.openLoginLibrarian();
            frmInitial.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmInitial.getbtnReservaLibro()) {
            frmInitial.mouseEntered(frmInitial.getbtnReservaLibro());
        } else if (e.getSource() == frmInitial.getbtnNotificacion()) {
            frmInitial.mouseEntered(frmInitial.getbtnNotificacion());
        } else if(e.getSource() == frmInitial.getbtnatras()) {
            frmInitial.mouseEntered(frmInitial.getbtnatras());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmInitial.getbtnReservaLibro()) {
            frmInitial.mouseExited(frmInitial.getbtnReservaLibro());
        } else if (e.getSource() == frmInitial.getbtnNotificacion()) {
            frmInitial.mouseExited(frmInitial.getbtnNotificacion());
        } else if(e.getSource() == frmInitial.getbtnatras()) {
            frmInitial.mouseExited(frmInitial.getbtnatras());
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

package com.company.system.controller;

import com.company.system.view.InitialWindow;
import com.company.system.view.components.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase es contiene todos los listeners necesarios para el funcionamiento de la ventana
 * llamada "InitialWindow" dentro del paquete view
 * @author artist-code (Daniel Mora Cantillo)
 */
public class InitialWindowListener implements ActionListener, MouseListener {

    private final InitialWindow frmInitial;

    public InitialWindowListener(InitialWindow frmInitial) {
        this.frmInitial = frmInitial;
        addListeners();
    }
    
    //Agrega escuchadores de eventos a cada componente de la ventana que lo necestia 
    private void addListeners() {
        frmInitial.getBtnLibrarianLogin().addActionListener(this);
        frmInitial.getBtnLibrarianLogin().addMouseListener(this);
        frmInitial.getBtnStudentLogin().addActionListener(this);
        frmInitial.getBtnStudentLogin().addMouseListener(this);
    }
    
    //Escuchador de eventos del click de los dos botones que tiene la ventana
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {

        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.openLoginLibrarian();
            frmInitial.close();
        }
    }
    
    //Escuchador de evento de los dos botones que tiene la ventana para cambiar color cuando el puntero esta sobre el bton
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {
            frmInitial.mouseEvent(frmInitial.getBtnStudentLogin(), Utils.btnEntered);
        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.mouseEvent(frmInitial.getBtnLibrarianLogin(), Utils.btnEntered);
        } 
    }
    
    //Escuchador de evento de los dos botones que tiene la ventana para cambiar color cuando el puntero sale del btn
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmInitial.getBtnStudentLogin()) {
            frmInitial.mouseEvent(frmInitial.getBtnStudentLogin(), Utils.btnExited);
        } else if (e.getSource() == frmInitial.getBtnLibrarianLogin()) {
            frmInitial.mouseEvent(frmInitial.getBtnLibrarianLogin(), Utils.btnExited);
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

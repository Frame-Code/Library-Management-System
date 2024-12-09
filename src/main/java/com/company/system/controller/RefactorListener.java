package com.company.system.controller;

import com.company.system.view.CategoryBooks;
import com.company.system.view.Refactor;
import com.company.system.view.components.Utils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class RefactorListener implements ActionListener, MouseListener {

    private final Refactor frmRefactor;

    public RefactorListener(Refactor frmRefactor) {
        this.frmRefactor = frmRefactor;
        addListeners();
    }

    private void addListeners() {
        //frmRefactor.getBtnCategoria().addActionListener(this);
        frmRefactor.getSubOpcion1().addActionListener(this);
        frmRefactor.getSubOpcion2().addActionListener(this);
        frmRefactor.getSubOpcion3().addActionListener(this);
        frmRefactor.getSubOpcion4().addActionListener(this);
        frmRefactor.getSubOpcion5().addActionListener(this);
        frmRefactor.getPnlCategory().addMouseListener(this);
        frmRefactor.getPnlAutor().addMouseListener(this);
        frmRefactor.getPnlEditorial().addMouseListener(this);
        frmRefactor.getPnlNotification().addMouseListener(this);
        frmRefactor.getPnlShutdown().addMouseListener(this);
        frmRefactor.getBtnSearch().addActionListener(this);
        frmRefactor.getBtnSearch().addMouseListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmRefactor.getBtnSearch()) {
            //------
        } else if (e.getSource() == frmRefactor.getSubOpcion1()) {
            frmRefactor.addToDesktopPane(new CategoryBooks("horror"));
        } else if (e.getSource() == frmRefactor.getSubOpcion2()) {
            frmRefactor.addToDesktopPane(new CategoryBooks("ciencia Ficcion"));
        } else if (e.getSource() == frmRefactor.getSubOpcion3()) {
            frmRefactor.addToDesktopPane(new CategoryBooks("Fantasia"));
        } else if (e.getSource() == frmRefactor.getSubOpcion4()) {
            frmRefactor.addToDesktopPane(new CategoryBooks("Romance"));
        } else if (e.getSource() == frmRefactor.getSubOpcion5()) {
            frmRefactor.addToDesktopPane(new CategoryBooks("Historia"));
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmRefactor.getPnlCategory()) {
            frmRefactor.getMenuContextual().show(frmRefactor.getPnlCategory(), frmRefactor.getPnlCategory().getWidth(), 0);
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlCategory());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmRefactor.getPnlCategory()) {
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlCategory());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlAutor());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlEditorial());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlNotification());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlShutdown());
        } else if (e.getSource() == frmRefactor.getPnlAutor()) {
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlCategory());
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlAutor());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlEditorial());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlNotification());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlShutdown());
        } else if (e.getSource() == frmRefactor.getPnlEditorial()) {
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlCategory());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlAutor());
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlEditorial());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlNotification());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlShutdown());
        } else if (e.getSource() == frmRefactor.getPnlNotification()) {
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlCategory());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlAutor());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlEditorial());
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlNotification());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlShutdown());
        } else if (e.getSource() == frmRefactor.getPnlShutdown()) {
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlCategory());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlAutor());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlEditorial());
            frmRefactor.changeColorPanel(Utils.pnlExited, frmRefactor.getPnlNotification());
            frmRefactor.changeColorPanel(Utils.pnlEntered, frmRefactor.getPnlShutdown());
        } else if (e.getSource() == frmRefactor.getBtnSearch()) {
            frmRefactor.mouseEvent(frmRefactor.getBtnSearch(), Utils.btnEntered);
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmRefactor.getBtnSearch()) {
            frmRefactor.mouseEvent(frmRefactor.getBtnSearch(), Utils.btnExited);
        } 
    }

}

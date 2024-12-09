package com.company.system.controller;

import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
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
public class LibraryHomeListener implements ActionListener, MouseListener {

    private final LibraryHome frmLibraryHome;

    public LibraryHomeListener(LibraryHome frmLibraryHome) {
        this.frmLibraryHome = frmLibraryHome;
        addListeners();
    }

    private void addListeners() {
        //frmRefactor.getBtnCategoria().addActionListener(this);
        frmLibraryHome.getSubOpcion1().addActionListener(this);
        frmLibraryHome.getSubOpcion2().addActionListener(this);
        frmLibraryHome.getSubOpcion3().addActionListener(this);
        frmLibraryHome.getSubOpcion4().addActionListener(this);
        frmLibraryHome.getSubOpcion5().addActionListener(this);
        frmLibraryHome.getPnlCategory().addMouseListener(this);
        frmLibraryHome.getPnlAutor().addMouseListener(this);
        frmLibraryHome.getPnlEditorial().addMouseListener(this);
        frmLibraryHome.getPnlNotification().addMouseListener(this);
        frmLibraryHome.getPnlShutdown().addMouseListener(this);
        frmLibraryHome.getBtnSearch().addActionListener(this);
        frmLibraryHome.getBtnSearch().addMouseListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmLibraryHome.getBtnSearch()) {
            //------
        } else if (e.getSource() == frmLibraryHome.getSubOpcion1()) {
            frmLibraryHome.addToDesktopPane(new CategoryBooks("horror"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion2()) {
            frmLibraryHome.addToDesktopPane(new CategoryBooks("ciencia Ficcion"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion3()) {
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Fantasia"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion4()) {
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Romance"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion5()) {
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Historia"));
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.getMenuContextual().show(frmLibraryHome.getPnlCategory(), frmLibraryHome.getPnlCategory().getWidth(), 0);
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
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
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlAutor());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlNotification());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlAutor()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlAutor());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlNotification());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlEditorial()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlAutor());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlNotification());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlNotification()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlAutor());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlNotification());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlAutor());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlNotification());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnEntered);
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnExited);
        } 
    }

}

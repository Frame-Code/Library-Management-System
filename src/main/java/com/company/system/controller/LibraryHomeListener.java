package com.company.system.controller;

import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.components.Utils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class LibraryHomeListener implements ActionListener, MouseListener {

    private final LibraryHome frmLibraryHome;
    private final BookService bookService;
    private final CategoryService categoryService;

    public LibraryHomeListener(LibraryHome frmLibraryHome) {
        this.frmLibraryHome = frmLibraryHome;
        this.bookService = new BookService();
        this.categoryService = new CategoryService();
        addListeners();
    }

    private void addListenerMenu() {
        frmLibraryHome.getMenuItems().forEach(menu -> {
            menu.addActionListener(this);
        });
    }

    private void addListeners() {
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
        frmLibraryHome.getMenuItems().forEach(menu -> {
            if(e.getSource() == menu) {
                frmLibraryHome.clearDesltopPane(); //Borrar desktop pane creado anteriormente
                CategoryBooks categoryBooksInternalFrm = new CategoryBooks(menu.getText()); //menu.getText() es para acceder al nombre del menu seleccionado
                
                Category categorySelected = categoryService.getCategoryByName(menu.getText());
                List<Book> booksByCategory = bookService.getBooksByCategory(categorySelected);
                categoryBooksInternalFrm.addBooks(booksByCategory);
                
                frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm); 
            }
        });
        /*
        
        if(e.getSource() == frmLibraryHome.getBtnSearch()) {
            //------
        } else if (e.getSource() == frmLibraryHome.getSubOpcion1()) {
            frmLibraryHome.clearDesltopPane();
            frmLibraryHome.addToDesktopPane(new CategoryBooks("horror"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion2()) {
            frmLibraryHome.clearDesltopPane();
            frmLibraryHome.addToDesktopPane(new CategoryBooks("ciencia Ficcion"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion3()) {
            frmLibraryHome.clearDesltopPane();
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Fantasia"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion4()) {
            frmLibraryHome.clearDesltopPane();
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Romance"));
        } else if (e.getSource() == frmLibraryHome.getSubOpcion5()) {
            frmLibraryHome.clearDesltopPane();
            frmLibraryHome.addToDesktopPane(new CategoryBooks("Historia"));
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.uploadListMenu(categoryService.getCategories());
            addListenerMenu();
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
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
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

package com.company.system.controller;

import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.components.Utils;
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
            if (e.getSource() == menu) {
                //Borrar cualquier JInternfalFrame creado anteriormente
                frmLibraryHome.clearDesltopPane(); 
                
                //menu.getText() es para acceder al nombre del menu seleccionado
                CategoryBooks categoryBooksInternalFrm = new CategoryBooks(menu.getText()); 

                //Obtener una instancia de la clase Categoria a traves de su nombre (nombre obtenido del submenu del menu contextual)
                Category categorySelected = categoryService.getCategoryByName(menu.getText()); 
                
                //Obtener una lista de libros filtrada por categoria (usando la categoria que se acaba de obtener)
                List<Book> booksByCategory = bookService.getBooksByCategory(categorySelected);
                
                //Agregando cada libro obtenido de la lista anterior y agregandolo al JInternalFrame
                categoryBooksInternalFrm.addBooks(booksByCategory);
                
                //Agregando el JInternalFrame al desktopPane de la ventana LibraryHome
                frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            //Cargando submenus al menu contextual con las categorias obtenidas de la base de datos
            frmLibraryHome.uploadListMenu(categoryService.getCategories());
            
            //Agregando listeners a cada submenu del menu contextual
            addListenerMenu();
            
            //Mostrar el menu contextual
            frmLibraryHome.getMenuContextual().show(frmLibraryHome.getPnlCategory(), frmLibraryHome.getPnlCategory().getWidth(), 0);
            
            //Cambiando el color de la opcion seleccionada
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
        }
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

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

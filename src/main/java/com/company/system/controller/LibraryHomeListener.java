package com.company.system.controller;

import com.company.system.service.PublisherService;
import com.company.system.service.UserService;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Publisher;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Ronald Seminario Santana
 */
public class LibraryHomeListener implements ActionListener, MouseListener, ComponentListener {

    private final LibraryHome frmLibraryHome;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final UserService userService;
    private CategoryBooks categoryBooksInternalFrm;

    public LibraryHomeListener(LibraryHome frmLibraryHome, UserService userService) {
        this.frmLibraryHome = frmLibraryHome;
        this.userService = userService;
        this.bookService = new BookService();
        this.categoryService = new CategoryService();
        this.publisherService = new PublisherService();
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

        // Agregar el MouseListener para el JLabel de Historial de Préstamos
        frmLibraryHome.getLblHistorialDePrestamos().addMouseListener(this);

        // Agregar MouseListener al JLabel lblSolicitar
        frmLibraryHome.getLblSolicitar().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frmLibraryHome.getMenuItems().forEach(menu -> {
            if (e.getSource() == menu) {
                // Borrar cualquier JInternalFrame creado anteriormente
                frmLibraryHome.clearDesltopPane();

                // menu.getText() es para acceder al nombre del menu seleccionado
                categoryBooksInternalFrm = new CategoryBooks(menu.getText(), bookService);
                categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());

                // Obtener una instancia de la clase Categoria a traves de su nombre
                Category categorySelected = categoryService.getCategoryByName(menu.getText());

                // Obtener una lista de libros filtrada por categoria
                List<Book> booksByCategory = bookService.getBooksByCategory(categorySelected);

                // Agregar cada libro obtenido de la lista anterior al JInternalFrame
                categoryBooksInternalFrm.addBooks(booksByCategory);

                // Agregar el JInternalFrame al desktopPane de la ventana LibraryHome
                frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlEditorial()) {
            // Obtener la lista de editoriales desde el servicio
            List<Publisher> publishers = publisherService.getPublisher();

            // Crear un menu contextual con los nombres de las editoriales
            JPopupMenu popupMenu = new JPopupMenu();
            publishers.forEach(publisher -> {
                JMenuItem menuItem = new JMenuItem(publisher.getName());
                popupMenu.add(menuItem);
            });

            // Mostrar el menu contextual en la posición del panel
            popupMenu.show(frmLibraryHome.getPnlEditorial(), frmLibraryHome.getPnlEditorial().getWidth() / 2, frmLibraryHome.getPnlEditorial().getHeight() / 2);

            // Cambiar el color del panel seleccionado
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlEditorial());
        } else if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.uploadListMenu(categoryService.getCategories());
            addListenerMenu();
            frmLibraryHome.getMenuContextual().show(frmLibraryHome.getPnlCategory(), frmLibraryHome.getPnlCategory().getWidth(), 0);
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
        } else if (e.getSource() == frmLibraryHome.getLblSolicitar()) {
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getLblSolicitar());
        } else if(e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.openLoginStudent(userService);
            frmLibraryHome.close();
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
        } else if (e.getSource() == frmLibraryHome.getLblSolicitar()) {
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getLblSolicitar());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnExited);
        } else if (e.getSource() == frmLibraryHome.getLblSolicitar()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getLblSolicitar());
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}

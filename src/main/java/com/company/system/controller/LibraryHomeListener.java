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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Ronald Seminario Santana
 */
public class LibraryHomeListener implements ActionListener, MouseListener, ComponentListener, KeyListener {

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

    private void searchBook() {
        List<Book> books = bookService.searchBook(frmLibraryHome.getTxtPatternToSearch().getText());
        frmLibraryHome.clearDesltopPane();
        categoryBooksInternalFrm = new CategoryBooks("Busqueda", bookService);
        categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());
        categoryBooksInternalFrm.addBooks(books);
        frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);
    }

    private void addListeners() {
        frmLibraryHome.getPnlCategory().addMouseListener(this);
        frmLibraryHome.getPnlLoanHistory().addMouseListener(this);
        frmLibraryHome.getPnlEditorial().addMouseListener(this);
        frmLibraryHome.getPnlShutdown().addMouseListener(this);
        frmLibraryHome.getBtnSearch().addActionListener(this);
        frmLibraryHome.getPnlRequest().addMouseListener(this);

        // Agregar el MouseListener para el JLabel de Historial de Préstamos
        frmLibraryHome.getLblHistorialDePrestamos().addMouseListener(this);

        frmLibraryHome.getBtnSearch().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            searchBook();
        }

        try {
            frmLibraryHome.getMenuItems().forEach((JMenuItem menu) -> {
                if (e.getSource() == menu) {
                    // Borrar cualquier JInternalFrame creado anteriormente
                    frmLibraryHome.clearDesltopPane();

                    // menu.getText() es para acceder al nombre del menu seleccionado
                    categoryBooksInternalFrm = new CategoryBooks(menu.getText(), bookService);
                    categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());

                    // Obtener una instancia de la clase Categoria a través de su nombre
                    Category categorySelected = categoryService.getCategoryByName(menu.getText());

                    // Obtener una lista de libros filtrada por categoría
                    List<Book> booksByCategory = bookService.getBooksByCategory(categorySelected);

                    // Agregar cada libro obtenido de la lista anterior al JInternalFrame
                    categoryBooksInternalFrm.addBooks(booksByCategory);

                    // Agregar el JInternalFrame al desktopPane de la ventana LibraryHome
                    frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);
                }
            });
        } catch (NullPointerException e1) {
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlEditorial()) {
            // Obtener la lista de editoriales desde el servicio
            List<Publisher> publishers = publisherService.getPublishers();

            // Crear un menu contextual con los nombres de las editoriales
            JPopupMenu popupMenu = new JPopupMenu();
            publishers.forEach(publisher -> {
                JMenuItem menuItem = new JMenuItem(publisher.getName());
                menuItem.addActionListener(ev -> {
                    String selectedPublisherName = menuItem.getText();

                    // Llamar al método en PublisherService con el nombre seleccionado
                    Publisher selectedPublisher = publisherService.getPublisherByName(selectedPublisherName);

                    // Obtener la lista de libros de esta editorial
                    List<Book> booksByPublisher = bookService.getBooksByPublisher(selectedPublisher);

                    // Crear un nuevo CategoryBooks Internal Frame con los libros obtenidos
                    frmLibraryHome.clearDesltopPane();
                    categoryBooksInternalFrm = new CategoryBooks("Editorial: " + selectedPublisher.getName(), bookService);
                    categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());

                    // Agregar cada libro al JInternalFrame
                    categoryBooksInternalFrm.addBooks(booksByPublisher);

                    // Agregar el JInternalFrame al desktopPane de la ventana LibraryHome
                    frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);

                    // Mostrar los detalles de la editorial seleccionada
                    System.out.println("Editorial seleccionada: " + selectedPublisher.getName());
                });
                popupMenu.add(menuItem);
            });

            // Mostrar el menu contextual en la posición del panel
            popupMenu.show(frmLibraryHome.getPnlEditorial(), e.getX(), e.getY());

            // Cambiar el color del panel seleccionado
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlEditorial());
        } else if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.uploadListMenu(categoryService.getCategories());
            addListenerMenu();
            frmLibraryHome.getMenuContextual().show(frmLibraryHome.getPnlCategory(), e.getX(), e.getY());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.openLoginStudent(userService);
            frmLibraryHome.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlCategory() || e.getSource() == frmLibraryHome.getLblCategory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlLoanHistory() || e.getSource() == frmLibraryHome.getLblLoanHistory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlEditorial() || e.getSource() == frmLibraryHome.getLblPublisher()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlRequest() || e.getSource() == frmLibraryHome.getLblRequest()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlRequest());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown() || e.getSource() == frmLibraryHome.getLblShutdown()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnEntered);
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
        } else if (e.getSource() == frmLibraryHome.getPnlLoanHistory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
        } else if (e.getSource() == frmLibraryHome.getPnlEditorial()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnExited);
        } else if (e.getSource() == frmLibraryHome.getPnlRequest()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void componentResized(ComponentEvent e) {}

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            searchBook();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}


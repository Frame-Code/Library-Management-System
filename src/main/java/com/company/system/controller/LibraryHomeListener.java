package com.company.system.controller;

import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.components.Utils;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        // Agregar el MouseListener para el JLabel de Historial de Préstamos
        frmLibraryHome.getLblHistorialDePrestamos().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frmLibraryHome.getMenuItems().forEach(menu -> {
            if (e.getSource() == menu) {
                // Borrar cualquier JInternalFrame creado anteriormente
                frmLibraryHome.clearDesltopPane(); 
                
                // menu.getText() es para acceder al nombre del menu seleccionado
                CategoryBooks categoryBooksInternalFrm = new CategoryBooks(menu.getText()); 

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
        if (e.getSource() == frmLibraryHome.getLblHistorialDePrestamos()) {
            // Limpiar cualquier JInternalFrame creado anteriormente
            frmLibraryHome.clearDesltopPane();

            // Crear un nuevo JInternalFrame para mostrar el historial
            JInternalFrame historialFrame = new JInternalFrame("Historial de Préstamos", true, true, true, true);
            historialFrame.setLayout(new BorderLayout());

            // Crear una tabla para mostrar el historial de préstamos
            JTable table = new JTable();

            // Datos de ejemplo para la tabla (puedes reemplazarlos con datos reales de tu servicio)
            Object[][] data = {
                {"2024-12-01", "Libro A", "Usuario 1"},
                {"2024-12-02", "Libro B", "Usuario 2"},
                {"2024-12-03", "Libro C", "Usuario 3"}
            };

            // Encabezados de la tabla
            String[] columnNames = {"Fecha", "Libro", "Usuario"};

            // Crear el modelo de tabla con los datos y los encabezados
            table.setModel(new DefaultTableModel(data, columnNames));

            // Agregar la tabla al internal frame
            historialFrame.add(new JScrollPane(table), BorderLayout.CENTER);

            // Configurar el tamaño y agregar el frame al desktop pane
            historialFrame.setSize(643, 527);
            frmLibraryHome.addToDesktopPane(historialFrame);

            // Hacer visible el internal frame
            historialFrame.setVisible(true);
        }

        // El resto de tus eventos mouseClicked para otros paneles
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            // Cargando submenus al menu contextual con las categorias obtenidas de la base de datos
            frmLibraryHome.uploadListMenu(categoryService.getCategories());
            
            // Agregando listeners a cada submenu del menu contextual
            addListenerMenu();
            
            // Mostrar el menu contextual
            frmLibraryHome.getMenuContextual().show(frmLibraryHome.getPnlCategory(), frmLibraryHome.getPnlCategory().getWidth(), 0);
            
            // Cambiando el color de la opción seleccionada
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
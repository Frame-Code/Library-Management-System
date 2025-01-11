package com.company.system.controller;

import com.company.system.model.Author;
import com.company.system.service.PublisherService;
import com.company.system.service.UserService;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Loan;
import com.company.system.model.Publisher;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.service.LoanService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.TableModel;
import com.company.system.view.components.Utils;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald Seminario Santana
 */
public class LibraryHomeListener implements ActionListener, MouseListener, ComponentListener, KeyListener, TableModel {

    private final LibraryHome frmLibraryHome;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final UserService userService;
    private final LoanService loanService; // Instancia de LoanService
    private CategoryBooks categoryBooksInternalFrm;

    public LibraryHomeListener(LibraryHome frmLibraryHome, UserService userService) {
        this.frmLibraryHome = frmLibraryHome;
        this.userService = userService;
        this.bookService = new BookService();
        this.categoryService = new CategoryService();
        this.publisherService = new PublisherService();
        this.loanService = new LoanService(); // Inicialización de LoanService
        frmLibraryHome.setStudent(userService.getLoggedUser(9412392L));
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
    if (e.getSource() == frmLibraryHome.getLblHistorialDePrestamos()) {
        // Instanciar y crear la tabla para mostrar el historial de préstamos
        List<Loan> loanHistory = loanService.getLoansByUser(frmLibraryHome.getStudent());

        // Crear el modelo de la tabla
        DefaultTableModel loanTableModel = getTableModelLoans(frmLibraryHome.getColumnNames(), loanHistory);

        // Crear la tabla con el modelo
        JTable loanHistoryTable = new JTable(loanTableModel);

        // Crear barras de texto o campos de entrada
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // Campos de entrada para la información del préstamo
        JTextField titleField = new JTextField(20);
        JTextField authorsField = new JTextField(20);
        JTextField categoryField = new JTextField(20);
        JTextField loanDateField = new JTextField(20);
        JTextField returnDateField = new JTextField(20);
        JLabel daysRemainingLabel = new JLabel("Días restantes: 0");
        JCheckBox returnedCheckBox = new JCheckBox("¿Devuelto?");

        // Si hay historial de préstamos, completamos los campos
        if (!loanHistory.isEmpty()) {
            Loan loan = loanHistory.get(0);

            // Mostrar el título del libro
            titleField.setText(loan.getBook().getTitle());

            // Obtener y mostrar los autores
            if (loan.getBook().getAuthors() != null && !loan.getBook().getAuthors().isEmpty()) {
                String authors = loan.getBook().getAuthors().stream()
                        .map(Author::getNames)
                        .collect(Collectors.joining(", "));
                authorsField.setText(authors);
            } else {
                authorsField.setText("No authors available");
            }

            // Obtener y mostrar la categoría
            if (loan.getBook().getCategory() != null) {
                categoryField.setText(loan.getBook().getCategory().getName());
            } else {
                categoryField.setText("No category available");
            }

            // Mostrar las fechas de préstamo y devolución
            loanDateField.setText(loan.getRegistrationDate().toString());
            returnDateField.setText(loan.getDevolutionDate().toString());

            // Mostrar si el préstamo fue devuelto
            returnedCheckBox.setSelected(loan.isReturned());

            // Calcular y mostrar los días restantes para devolución
            long daysRemaining = ChronoUnit.DAYS.between(LocalDate.now(), loan.getDevolutionDate());
            daysRemainingLabel.setText("Días restantes: " + daysRemaining);
        }

        // Agregar los campos al formulario
        formPanel.add(new JLabel("Título:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Autor(es):"));
        formPanel.add(authorsField);
        formPanel.add(new JLabel("Categoría/Temática:"));
        formPanel.add(categoryField);
        formPanel.add(new JLabel("Fecha de Préstamo:"));
        formPanel.add(loanDateField);
        formPanel.add(new JLabel("Fecha de Devolución:"));
        formPanel.add(returnDateField);
        formPanel.add(daysRemainingLabel);
        formPanel.add(new JLabel("¿Devuelto?"));
        formPanel.add(returnedCheckBox);

        // Crear un JInternalFrame para mostrar la tabla y el formulario
        JInternalFrame loanHistoryInternalFrame = new JInternalFrame("Historial de Préstamos", true, true, true, true);
        loanHistoryInternalFrame.setLayout(new BorderLayout());

        // Crear un panel para la tabla y el formulario
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crear un panel para contener la tabla
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(loanHistoryTable), BorderLayout.CENTER);

        // Agregar el panel de la tabla al panel principal
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Agregar el formulario a la derecha del panel principal
        mainPanel.add(formPanel, BorderLayout.EAST);

        // Agregar el panel principal al InternalFrame
        loanHistoryInternalFrame.add(mainPanel, BorderLayout.CENTER);

        // Establecer el tamaño del InternalFrame
        loanHistoryInternalFrame.setSize(frmLibraryHome.getDesktopPane().getSize());

        // Mostrar el InternalFrame en el DesktopPane
        frmLibraryHome.clearDesltopPane();
        frmLibraryHome.addToDesktopPane(loanHistoryInternalFrame);
        loanHistoryInternalFrame.setVisible(true);
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
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void componentResized(ComponentEvent e) {
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

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            searchBook();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

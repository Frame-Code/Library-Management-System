package com.company.system.controller;

import com.company.system.model.Author;
import com.company.system.service.PublisherService;
import com.company.system.service.UserService;
import com.company.system.model.Book;
import com.company.system.model.Category;
import com.company.system.model.Loan;
import com.company.system.model.Publisher;
import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.CategoryService;
import com.company.system.service.LoanService;
import com.company.system.view.CategoryBooks;
import com.company.system.view.LibraryHome;
import com.company.system.view.TableModel;
import com.company.system.view.components.Utils;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald Seminario Santana
 */
public class LibraryHomeListener implements ActionListener, MouseListener, ComponentListener, KeyListener, TableModel {

    // Referencia a la ventana principal de la aplicación
    private final LibraryHome frmLibraryHome;

    // Servicios para manejar las diferentes operaciones en la aplicación
    private final BookService bookService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;
    private final UserService userService;
    private final LoanService loanService; // Servicio para manejar préstamos

    // Ventana interna para mostrar libros por categoría
    private CategoryBooks categoryBooksInternalFrm;

    /**
     * Constructor de la clase. Inicializa los servicios y configura los
     * listeners.
     *
     * @param frmLibraryHome Referencia a la ventana principal de la aplicación.
     * @param userService Servicio de usuario para obtener información del
     * usuario.
     */
    public LibraryHomeListener(LibraryHome frmLibraryHome, User student, UserService userService) {
        this.frmLibraryHome = frmLibraryHome;
        this.userService = userService;
        this.bookService = new BookService();
        this.categoryService = new CategoryService();
        this.publisherService = new PublisherService();
        this.loanService = new LoanService(); // Inicialización del servicio de préstamos

        // Configuración inicial del estudiante actual en la ventana principal
        frmLibraryHome.setStudent(student);
        addListeners(); // Método para añadir todos los listeners necesarios
    }

    /**
     * Agrega listeners a los elementos del menú de la ventana principal.
     */
    private void addListenerMenu() {
        frmLibraryHome.getMenuItems().forEach(menu -> {
            menu.addActionListener(this); // Asigna este listener a cada ítem del menú
        });
    }

    /**
     * Busca libros en base a un patrón ingresado por el usuario y muestra los
     * resultados.
     */
    private void searchBook() {
        // Obtiene la lista de libros que coinciden con el patrón de búsqueda
        List<Book> books = bookService.searchBook(frmLibraryHome.getTxtPatternToSearch().getText());

        // Limpia el DesktopPane antes de mostrar nuevos resultados
        frmLibraryHome.clearDesltopPane();

        // Crea una nueva ventana interna para mostrar los resultados
        categoryBooksInternalFrm = new CategoryBooks("Busqueda", bookService);
        categoryBooksInternalFrm.setSize(frmLibraryHome.getDesktopPane().getSize());

        // Agrega los libros encontrados a la ventana interna
        categoryBooksInternalFrm.addBooks(books);

        // Añade la ventana interna al DesktopPane
        frmLibraryHome.addToDesktopPane(categoryBooksInternalFrm);
    }

    /**
     * Agrega los listeners a los elementos principales de la interfaz gráfica.
     */
    private void addListeners() {
        // Añade MouseListeners a los paneles interactivos
        frmLibraryHome.getPnlCategory().addMouseListener(this);
        frmLibraryHome.getPnlLoanHistory().addMouseListener(this);
        frmLibraryHome.getPnlEditorial().addMouseListener(this);
        frmLibraryHome.getPnlShutdown().addMouseListener(this);
        frmLibraryHome.getBtnSearch().addActionListener(this);
        frmLibraryHome.getPnlRequest().addMouseListener(this);

        // Listener para el botón de búsqueda
        frmLibraryHome.getBtnSearch().addActionListener(this);
        frmLibraryHome.getBtnSearch().addMouseListener(this);

        // Listener para etiquetas específicas
        frmLibraryHome.getLblHistorialDePrestamos().addMouseListener(this);
        frmLibraryHome.getLblRequest().addMouseListener(this);
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

        if (e.getSource() == frmLibraryHome.getLblRequest()) {
            // Obtener el usuario actual (suponiendo que tienes acceso al usuario en el contexto)
            User currentUser = frmLibraryHome.getStudent();

            // Verificar si el usuario tiene préstamos pendientes
            if (!loanService.hasPendingBookForExtension(currentUser)) {
                JOptionPane.showMessageDialog(frmLibraryHome, "No tienes un libro pendiente para solicitar prórroga.");
                return;
            }

            // Verificar que el usuario tenga menos de 3 multas
            if (!loanService.checkFinesToRequestExtension(currentUser)) {
                JOptionPane.showMessageDialog(frmLibraryHome, "Tienes más de 3 multas o tu última multa no ha pasado su fecha límite.");
                return;
            }

            // Verificar si el usuario ya solicitó una prórroga
            if (loanService.hasAlreadyRequestedExtension(currentUser)) {
                JOptionPane.showMessageDialog(frmLibraryHome, "Ya has solicitado una prórroga para este libro.");
                return;
            }

            // Obtener el último préstamo
            Loan lastLoan = new LinkedList<>(loanService.getLoansByUser(currentUser)).getLast();

            // Verificar que la fecha actual no sobrepase la fecha de devolución registrada
            if (LocalDate.now().isAfter(lastLoan.getDevolutionDate())) {
                JOptionPane.showMessageDialog(frmLibraryHome, "La fecha actual ya ha pasado la fecha de devolución registrada.");
                return;
            }

            // Mostrar el formulario para solicitar la prórroga
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

            // Crear un campo de texto para ingresar el año (4 caracteres de ancho).
            JTextField yearField = new JTextField(4);

            // Crear un combo box para seleccionar el mes con nombres en español.
            JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            });

            // Crear un campo de texto para ingresar el día (2 caracteres de ancho).
            JTextField dayField = new JTextField(2);

            // Crear un panel para agrupar los elementos de entrada de la fecha.
            JPanel datePanel = new JPanel();
            datePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Configurar un diseño de flujo centrado.
            datePanel.add(new JLabel("Día:")); // Etiqueta para el campo del día.
            datePanel.add(dayField);           // Agregar el campo de texto del día.
            datePanel.add(new JLabel("Mes:")); // Etiqueta para el combo box del mes.
            datePanel.add(monthComboBox);      // Agregar el combo box del mes.
            datePanel.add(new JLabel("Año:")); // Etiqueta para el campo del año.
            datePanel.add(yearField);          // Agregar el campo de texto del año.

            // Crear un panel para el formulario principal.
            formPanel.add(new JLabel("Nueva Fecha de Devolución:")); // Etiqueta descriptiva para el formulario.
            formPanel.add(datePanel); // Agregar el panel con los elementos de la fecha al formulario.

            // Crear un botón para enviar la solicitud de prórroga.
            JButton requestButton = new JButton("Solicitar Prórroga");
            formPanel.add(requestButton); // Agregar el botón al formulario.

            // Agregar un ActionListener al botón para guardar la información
            requestButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Obtener el día, mes y año ingresados por el usuario
                        int day = Integer.parseInt(dayField.getText());
                        int month = monthComboBox.getSelectedIndex() + 1;  // El combo box está basado en índices, sumar 1 para obtener el mes real
                        int year = Integer.parseInt(yearField.getText());

                        // Crear la nueva fecha de devolución
                        LocalDate newDevolutionDate = LocalDate.of(year, month, day);

                        // Verificar que la fecha de devolución no sea en el pasado
                        if (newDevolutionDate.isBefore(LocalDate.now())) {
                            JOptionPane.showMessageDialog(frmLibraryHome, "La nueva fecha de devolución no puede ser en el pasado.");
                            return;
                        }

                        // Llamar al servicio para solicitar la prórroga
                        boolean success = loanService.requestExtension(currentUser, newDevolutionDate);

                        // Mostrar un mensaje según el resultado
                        if (success) {
                            JOptionPane.showMessageDialog(frmLibraryHome, "Prórroga solicitada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(frmLibraryHome, "No se pudo solicitar la prórroga. Verifique las condiciones.");
                        }
                    } catch (NumberFormatException ex) {
                        // Manejar la excepción si los campos de día, mes o año no son válidos
                        JOptionPane.showMessageDialog(frmLibraryHome, "Por favor, ingresa una fecha válida.");
                    }
                }
            });

            // Crear una ventana interna (JInternalFrame) para la solicitud de prórroga.
            JInternalFrame requestExtensionInternalFrame = new JInternalFrame(
                    "Solicitar Prórroga", // Título de la ventana.
                    true, // Hacer que la ventana sea redimensionable.
                    true, // Hacer que la ventana sea cerrable.
                    true, // Hacer que la ventana sea maximizable.
                    true // Hacer que la ventana sea iconificable.
            );
            requestExtensionInternalFrame.setLayout(new BorderLayout()); // Establecer un diseño de bordes.
            requestExtensionInternalFrame.add(formPanel, BorderLayout.CENTER); // Agregar el formulario al centro de la ventana interna.
            requestExtensionInternalFrame.setSize(frmLibraryHome.getDesktopPane().getSize()); // Ajustar el tamaño de la ventana interna al tamaño del desktop pane.

            // Limpiar el desktop pane antes de agregar la nueva ventana.
            frmLibraryHome.clearDesltopPane();

            // Agregar la ventana interna al desktop pane de frmLibraryHome.
            frmLibraryHome.addToDesktopPane(requestExtensionInternalFrame);

            // Hacer visible la ventana interna.
            requestExtensionInternalFrame.setVisible(true);
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.close();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Detecta cuando el mouse entra en un componente específico y cambia el color de los paneles
        if (e.getSource() == frmLibraryHome.getPnlCategory() || e.getSource() == frmLibraryHome.getLblCategory()) {
            // Cambia el color del panel "PnlCategory" a "pnlEntered" y los demás a "pnlExited"
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlLoanHistory() || e.getSource() == frmLibraryHome.getLblLoanHistory()) {
            // Cambia el color del panel "PnlLoanHistory" a "pnlEntered" y los demás a "pnlExited"
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlEditorial() || e.getSource() == frmLibraryHome.getLblPublisher()) {
            // Cambia el color del panel "PnlEditorial" a "pnlEntered" y los demás a "pnlExited"
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getPnlRequest() || e.getSource() == frmLibraryHome.getLblRequest()) {
            // Cambia el color del panel "PnlRequest" a "pnlEntered" y los demás a "pnlExited"
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlRequest());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown() || e.getSource() == frmLibraryHome.getLblShutdown()) {
            // Cambia el color del panel "PnlShutdown" a "pnlEntered" y los demás a "pnlExited"
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
            frmLibraryHome.changeColorPanel(Utils.pnlEntered, frmLibraryHome.getPnlShutdown());
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        } else if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            // Detecta cuando el mouse entra en el botón de búsqueda y cambia su color
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Detecta cuando el mouse sale de un componente y cambia el color de los paneles de vuelta
        if (e.getSource() == frmLibraryHome.getPnlCategory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlCategory());
        } else if (e.getSource() == frmLibraryHome.getPnlLoanHistory()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlLoanHistory());
        } else if (e.getSource() == frmLibraryHome.getPnlEditorial()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlEditorial());
        } else if (e.getSource() == frmLibraryHome.getPnlShutdown()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlShutdown());
        } else if (e.getSource() == frmLibraryHome.getBtnSearch()) {
            // Detecta cuando el mouse sale del botón de búsqueda y cambia su color
            frmLibraryHome.mouseEvent(frmLibraryHome.getBtnSearch(), Utils.btnExited);
        } else if (e.getSource() == frmLibraryHome.getPnlRequest()) {
            frmLibraryHome.changeColorPanel(Utils.pnlExited, frmLibraryHome.getPnlRequest());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este método se llama cuando se presiona un botón del ratón sobre un componente.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este método se llama cuando se libera el botón del ratón sobre un componente.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // Este método se llama cuando un componente es redimensionado.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // Este método se llama cuando un componente es movido a una nueva posición.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // Este método se llama cuando un componente se hace visible.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // Este método se llama cuando un componente se oculta.
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Este método se llama cuando una tecla es presionada.
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Si la tecla presionada es la tecla Enter (código VK_ENTER),
            // se llama a la función searchBook() para realizar una búsqueda.
            searchBook();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método se llama cuando se ingresa un carácter (escribe una tecla).
        // Actualmente no se implementa ninguna acción específica.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Este método se llama cuando se suelta una tecla.
        // Actualmente no se implementa ninguna acción específica.
    }
}

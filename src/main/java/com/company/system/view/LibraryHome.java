package com.company.system.view;

import com.company.system.controller.LoginStudentListener;
import com.company.system.model.Category;
import com.company.system.model.User;
import com.company.system.service.UserService;
import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LibraryHome extends javax.swing.JFrame {
    private User student;
    private JPopupMenu menuContextual;
    private ArrayList<JMenuItem> menuItems;
    private String columnNames[] = new String[] {"Titulo libro", "Fecha devolucion esperado", "Ha sido devuelto?", "fecha registro", "Ha soliticado prorroga?"};
    
    public LibraryHome(User user) {
        //this.user = user;
        this.student = new User(); //Eliminar esta linea
        this.student.setNames("ejemplo");  //Eliminar esta linea
        this.student.setSurNames("ejemplo1"); //eliminar esta linea
        initComponents();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("System management student, made with <3");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/libraryIconPrincipal.png")));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new BackgroundPanel("src/main/resources/images/Background_login.png");
        pnlBackground = new RoundedPanelWithShadow(30, new Color(0, 0, 0, 100), 2);
        pnlWelcome = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblWelcome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblBookIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        pnlCategory = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblCategory = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlLoanHistory = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblLoanHistory = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlEditorial = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblPublisher = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlRequest = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblRequest = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlShutdown = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 1);
        lblShutdown = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        pnlWelcome1 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        txtPatternToSearch = new javax.swing.JTextField();
        btnSearch = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        lblCategory1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(79, 90, 100));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setForeground(new java.awt.Color(255, 255, 255));

        pnlWelcome.setBackground(new java.awt.Color(56, 75, 147));
        pnlWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("BIENVENIDO");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Student_login_icon_mini.png"))); // NOI18N

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("User");

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcome)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUser))
                    .addComponent(jLabel3))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlCategory.setBackground(new java.awt.Color(255, 255, 255));
        pnlCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCategory.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory.setText("Categoria");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoriesIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlCategoryLayout = new javax.swing.GroupLayout(pnlCategory);
        pnlCategory.setLayout(pnlCategoryLayout);
        pnlCategoryLayout.setHorizontalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCategoryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblCategory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCategoryLayout.setVerticalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblCategory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLoanHistory.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoanHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblLoanHistory.setBackground(new java.awt.Color(255, 255, 255));
        lblLoanHistory.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblLoanHistory.setForeground(new java.awt.Color(0, 0, 0));
        lblLoanHistory.setText("Historial De Prestamos");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/authorIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlLoanHistoryLayout = new javax.swing.GroupLayout(pnlLoanHistory);
        pnlLoanHistory.setLayout(pnlLoanHistoryLayout);
        pnlLoanHistoryLayout.setHorizontalGroup(
            pnlLoanHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoanHistoryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoanHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLoanHistoryLayout.setVerticalGroup(
            pnlLoanHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoanHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoanHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoanHistory)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEditorial.setBackground(new java.awt.Color(255, 255, 255));
        pnlEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblPublisher.setBackground(new java.awt.Color(255, 255, 255));
        lblPublisher.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblPublisher.setForeground(new java.awt.Color(0, 0, 0));
        lblPublisher.setText("Editorial");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/publisherIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlEditorialLayout = new javax.swing.GroupLayout(pnlEditorial);
        pnlEditorial.setLayout(pnlEditorialLayout);
        pnlEditorialLayout.setHorizontalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditorialLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblPublisher)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEditorialLayout.setVerticalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorialLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblPublisher))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRequest.setBackground(new java.awt.Color(255, 255, 255));
        pnlRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblRequest.setBackground(new java.awt.Color(255, 255, 255));
        lblRequest.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblRequest.setForeground(new java.awt.Color(0, 0, 0));
        lblRequest.setText("Solicitar prorroga");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Request_extension.png"))); // NOI18N

        javax.swing.GroupLayout pnlRequestLayout = new javax.swing.GroupLayout(pnlRequest);
        pnlRequest.setLayout(pnlRequestLayout);
        pnlRequestLayout.setHorizontalGroup(
            pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRequestLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblRequest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRequestLayout.setVerticalGroup(
            pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequestLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblRequest))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlShutdown.setBackground(new java.awt.Color(255, 255, 255));
        pnlShutdown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblShutdown.setBackground(new java.awt.Color(255, 255, 255));
        lblShutdown.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblShutdown.setForeground(new java.awt.Color(0, 0, 0));
        lblShutdown.setText("Salir");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shutdownIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlShutdownLayout = new javax.swing.GroupLayout(pnlShutdown);
        pnlShutdown.setLayout(pnlShutdownLayout);
        pnlShutdownLayout.setHorizontalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShutdownLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShutdown)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShutdownLayout.setVerticalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShutdownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShutdown))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(pnlLoanHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblBookIcon)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnlCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(pnlLoanHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pnlRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(pnlShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlWelcome1.setBackground(new java.awt.Color(255, 255, 255));
        pnlWelcome1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtPatternToSearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtPatternToSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearch.setBackground(new java.awt.Color(56, 75, 147));
        btnSearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.setBorder(null);

        lblCategory1.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        lblCategory1.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory1.setText("Buscar libro por titulo:");

        javax.swing.GroupLayout pnlWelcome1Layout = new javax.swing.GroupLayout(pnlWelcome1);
        pnlWelcome1.setLayout(pnlWelcome1Layout);
        pnlWelcome1Layout.setHorizontalGroup(
            pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcome1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcome1Layout.createSequentialGroup()
                        .addComponent(lblCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlWelcome1Layout.createSequentialGroup()
                        .addComponent(txtPatternToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        pnlWelcome1Layout.setVerticalGroup(
            pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcome1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategory1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatternToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktopPane))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(pnlWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desktopPane))
                    .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void uploadListMenu(List<Category> categories) {
        menuContextual = new JPopupMenu();
        menuItems = new ArrayList<>();
        categories.forEach(category -> {
            menuItems.add(new JMenuItem(category.getName()));
        });
        
        menuItems.forEach(menu -> {
            menuContextual.add(menu);
        });
    }

    public void addToDesktopPane(JInternalFrame jInternal) {
        this.desktopPane.add(jInternal);
        jInternal.setVisible(true);
    }
    
    public void clearDesltopPane() {
        this.desktopPane.removeAll();
    }
    
    public void changeColorPanel(Color color, Component component) {
        if (component instanceof JPanel) {
            ((JPanel) component).setBackground(color);
        } else if (component instanceof JLabel) {
            ((JLabel) component).setOpaque(true);
            ((JLabel) component).setBackground(color);
        }
    }

    public void openLoginStudent(UserService userService) {
        LoginStudent loginStudent = new LoginStudent();
        new LoginStudentListener(loginStudent, userService);
        loginStudent.setVisible(true);
    }


    //Este metodo cierra esta ventana
    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    //Este metodo es usado para cambiar el color a los btn cuando el puntero este sobre el btn o salga del mismo
    public void mouseEvent(JButton btn, Color color) {
        btn.setBackground(color);
    }
    
    public JPopupMenu getMenuContextual() {
        return menuContextual;
    }

    public ArrayList<JMenuItem> getMenuItems() {
        return menuItems;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JPanel getPnlCategory() {
        return pnlCategory;
    }

    public JPanel getPnlLoanHistory() {
        return pnlLoanHistory;
    }

    public JPanel getPnlEditorial() {
        return pnlEditorial;
    }

    public JPanel getPnlRequest() {
        return pnlRequest;
    }

    public JPanel getPnlShutdown() {
        return pnlShutdown;
    }

    public JLabel getLblCategory() {
        return lblCategory;
    }

    public JLabel getLblLoanHistory() {
        return lblLoanHistory;
    }

    public JLabel getLblPublisher() {
        return lblPublisher;
    }

    public JLabel getLblRequest() {
        return lblRequest;
    }

    public JLabel getLblShutdown() {
        return lblShutdown;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JLabel getLblHistorialDePrestamos() {
        return lblLoanHistory;
    }


    public JTextField getTxtPatternToSearch() {
        return txtPatternToSearch;
    }

    public User getStudent() {
        return student;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
    
    //ELiminar este setter porque el estudiante ya estara cargado y no cambiara//
    public void setStudent(User student) {
        this.student = student;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel contentPane;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblLoanHistory;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JLabel lblShutdown;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlEditorial;
    private javax.swing.JPanel pnlLoanHistory;
    private javax.swing.JPanel pnlRequest;
    private javax.swing.JPanel pnlShutdown;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcome1;
    private javax.swing.JTextField txtPatternToSearch;
    // End of variables declaration//GEN-END:variables
}

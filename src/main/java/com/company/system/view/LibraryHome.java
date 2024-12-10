package com.company.system.view;

//import com.company.system.controller.LoginLibrarianListener;
//import com.company.system.controller.LoginStudentListener;
import com.company.system.controller.LibraryHomeListener;
import com.company.system.model.Category;
import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LibraryHome extends javax.swing.JFrame {
    private JPopupMenu menuContextual;
    private ArrayList<JMenuItem> menuItems;
    
    public LibraryHome() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        new LibraryHomeListener(this);
    }
    

    @SuppressWarnings("unchecked")
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
        pnlAutor = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblAutor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlEditorial = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblCategory2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlNotification = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblCategory3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlShutdown = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 1);
        lblCategory4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        desktopPane = new javax.swing.JDesktopPane();
        pnlWelcome1 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        txtIdUser = new javax.swing.JTextField();
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

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/Student_login_icon_mini.png")); // NOI18N

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
                .addContainerGap(41, Short.MAX_VALUE))
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

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/All_categories(1).png")); // NOI18N

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

        pnlAutor.setBackground(new java.awt.Color(255, 255, 255));
        pnlAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblAutor.setBackground(new java.awt.Color(255, 255, 255));
        lblAutor.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(0, 0, 0));
        lblAutor.setText("Autor");

        jLabel5.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/4649486-200(1).png")); // NOI18N

        javax.swing.GroupLayout pnlAutorLayout = new javax.swing.GroupLayout(pnlAutor);
        pnlAutor.setLayout(pnlAutorLayout);
        pnlAutorLayout.setHorizontalGroup(
            pnlAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAutorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAutorLayout.setVerticalGroup(
            pnlAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAutor)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEditorial.setBackground(new java.awt.Color(255, 255, 255));
        pnlEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCategory2.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblCategory2.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory2.setText("Editorial");

        jLabel6.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/1277216(3).png")); // NOI18N

        javax.swing.GroupLayout pnlEditorialLayout = new javax.swing.GroupLayout(pnlEditorial);
        pnlEditorial.setLayout(pnlEditorialLayout);
        pnlEditorialLayout.setHorizontalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditorialLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblCategory2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEditorialLayout.setVerticalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorialLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblCategory2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNotification.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotification.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCategory3.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblCategory3.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory3.setText("Notificaciones");

        jLabel7.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/565422(1)(3).png")); // NOI18N

        javax.swing.GroupLayout pnlNotificationLayout = new javax.swing.GroupLayout(pnlNotification);
        pnlNotification.setLayout(pnlNotificationLayout);
        pnlNotificationLayout.setHorizontalGroup(
            pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblCategory3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNotificationLayout.setVerticalGroup(
            pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificationLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblCategory3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlShutdown.setBackground(new java.awt.Color(255, 255, 255));
        pnlShutdown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCategory4.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory4.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblCategory4.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory4.setText("Salir");

        jLabel8.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/shutdown-31(2).png")); // NOI18N

        javax.swing.GroupLayout pnlShutdownLayout = new javax.swing.GroupLayout(pnlShutdown);
        pnlShutdown.setLayout(pnlShutdownLayout);
        pnlShutdownLayout.setHorizontalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShutdownLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCategory4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShutdownLayout.setVerticalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShutdownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory4))
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
                    .addComponent(pnlAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(30, 30, 30)
                .addComponent(pnlAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pnlNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(pnlShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );
	
	desktopPane.setPreferredSize(new java.awt.Dimension(800, 600));
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

        txtIdUser.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtIdUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUserActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(56, 75, 147));
        btnSearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblCategory1.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        lblCategory1.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory1.setText("Buscar libro por nombre:");

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
                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

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

    public JPanel getPnlAutor() {
        return pnlAutor;
    }

    public JPanel getPnlEditorial() {
        return pnlEditorial;
    }

    public JPanel getPnlNotification() {
        return pnlNotification;
    }

    public JPanel getPnlShutdown() {
        return pnlShutdown;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public void addToDesktopPane(JInternalFrame jInternal) {
        this.desktopPane.add(jInternal);
        jInternal.setVisible(true);
    }
    
    public void clearDesltopPane() {
        this.desktopPane.removeAll();
    }
    
    public void changeColorPanel(Color color, JPanel pnl) {
        pnl.setBackground(color);
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
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblCategory2;
    private javax.swing.JLabel lblCategory3;
    private javax.swing.JLabel lblCategory4;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlAutor;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlEditorial;
    private javax.swing.JPanel pnlNotification;
    private javax.swing.JPanel pnlShutdown;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcome1;
    private javax.swing.JTextField txtIdUser;
    // End of variables declaration//GEN-END:variables
}

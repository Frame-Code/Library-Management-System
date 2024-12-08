package com.company.system.view;

import com.company.system.controller.LoginLibrarianListener;
import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class InitialWindow extends javax.swing.JFrame {

    public InitialWindow() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new BackgroundPanel("src/main/resources/images/Background_login.png");
        pnlBackground = new RoundedPanelWithShadow(30, new Color(0, 0, 0, 100), 2);
        pnlWelcome = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblSelectTypeAccount = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnLibrarianLogin = new RoundedButtonWithShadow("ESTUDIANTE", 7, new Color(0, 0, 0, 100), 4);
        btnStudentLogin = new RoundedButtonWithShadow("ESTUDIANTE", 7, new Color(0, 0, 0, 100), 4);
        lblStudentIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        lblLibrarianIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        lblBookIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        lblManagmentSystem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(79, 90, 100));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setForeground(new java.awt.Color(255, 255, 255));

        pnlWelcome.setBackground(new java.awt.Color(56, 75, 147));
        pnlWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblSelectTypeAccount.setBackground(new java.awt.Color(255, 255, 255));
        lblSelectTypeAccount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblSelectTypeAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectTypeAccount.setText("Seleccione el tipo de cuenta para comenzar...");

        lblWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("BIENVENIDO");

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcome)
                .addGap(184, 184, 184))
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblSelectTypeAccount)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelectTypeAccount)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnLibrarianLogin.setBackground(new java.awt.Color(56, 75, 147));
        btnLibrarianLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnLibrarianLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLibrarianLogin.setText("Ingresar como bibliotecario");
        btnLibrarianLogin.setBorder(null);

        btnStudentLogin.setBackground(new java.awt.Color(56, 75, 147));
        btnStudentLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnStudentLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentLogin.setText("Ingresar como estudiante");
        btnStudentLogin.setBorder(null);

        lblStudentIcon.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/Student_login_icon.png")); // NOI18N

        lblLibrarianIcon.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/Librarian_login_icon.png")); // NOI18N

        lblBookIcon.setIcon(new javax.swing.ImageIcon("/home/artist-code/Documents/Library/Library-Managment-System/src/main/resources/images/Books_login_icon.png")); // NOI18N

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblStudentIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnStudentLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnLibrarianLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblLibrarianIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblBookIcon)
                    .addContainerGap(573, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLibrarianIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLibrarianLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(251, Short.MAX_VALUE)))
        );

        lblManagmentSystem.setBackground(new java.awt.Color(153, 153, 153));
        lblManagmentSystem.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblManagmentSystem.setForeground(new java.awt.Color(255, 255, 255));
        lblManagmentSystem.setText("Sistema de gestión de la biblioteca universitaria");

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lblManagmentSystem)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblManagmentSystem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Este metodo abre la ventana "LoginLibrarian" y le asigna su respectivo listener
    public void openLoginLibrarian() {
        frmLoginLibrarian = new LoginLibrarian();
        frmLoginLibrarian.setVisible(true);
        new LoginLibrarianListener(frmLoginLibrarian);
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
    
    
    public JButton getBtnLibrarianLogin() {
        return btnLibrarianLogin;
    }

    public JButton getBtnStudentLogin() {
        return btnStudentLogin;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LoginLibrarian frmLoginLibrarian;
    private javax.swing.JButton btnLibrarianLogin;
    private javax.swing.JButton btnStudentLogin;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblLibrarianIcon;
    private javax.swing.JLabel lblManagmentSystem;
    private javax.swing.JLabel lblSelectTypeAccount;
    private javax.swing.JLabel lblStudentIcon;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlWelcome;
    // End of variables declaration//GEN-END:variables
}

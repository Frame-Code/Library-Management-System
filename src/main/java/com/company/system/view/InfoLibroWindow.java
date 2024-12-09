package com.company.system.view;

import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class InfoLibroWindow extends javax.swing.JFrame {
//CONFIGURACIONES BASICAS PARA LA VENTANA EN LA APLICAION DE GESTION BIBLIOTECARIA
    public InfoLibroWindow() {
        initComponents();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        contentPane = new BackgroundPanel("src/main/resources/images/Background_login.png");
        pnlBackground = new RoundedPanelWithShadow(30, new Color(0, 0, 0, 100), 2);
        pnlWelcome = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblSelectTypeAccount = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblStudentIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        lblLibrarianIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        lblBookIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        jLabel1 = new javax.swing.JLabel();
        textfielAuthor = new javax.swing.JTextField();
        textfieldDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textfielISBN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textfielCategory = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textfieldPublisher = new javax.swing.JTextField();
        lblImage = new javax.swing.JLabel();
        textfieldfStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblManagmentSystem = new javax.swing.JLabel();
        btnNotify = new RoundedButtonWithShadow("ESTUDIANTE", 7, new Color(0, 0, 0, 100), 4);
        btnBack = new RoundedButtonWithShadow("ESTUDIANTE", 7, new Color(0, 0, 0, 100), 4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(79, 90, 100));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setForeground(new java.awt.Color(255, 255, 255));

        pnlWelcome.setBackground(new java.awt.Color(56, 75, 147));
        pnlWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblSelectTypeAccount.setBackground(new java.awt.Color(255, 255, 255));
        lblSelectTypeAccount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblSelectTypeAccount.setForeground(new java.awt.Color(255, 255, 255));

        lblBookName.setBackground(new java.awt.Color(255, 255, 255));
        lblBookName.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblBookName.setForeground(new java.awt.Color(255, 255, 255));
        lblBookName.setText("LIBRO \"X\"");

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblSelectTypeAccount))
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(lblBookName)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBookName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelectTypeAccount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Autor:");

        textfielAuthor.setEnabled(false);

        textfieldDate.setEnabled(false);

        jLabel9.setText("IMAGEN DEL LIBRO xd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Stock Disponible:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ISBN:");

        textfielISBN.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Fecha publicacion");

        textfielCategory.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        txtAreaDescription.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaDescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Editorial:");

        textfieldPublisher.setEnabled(false);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/last-day-of-the-funny-mustache.jpg"))); // NOI18N

        textfieldfStock.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Categoría:");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldDate)
                                    .addComponent(textfieldPublisher)
                                    .addComponent(textfieldfStock)
                                    .addComponent(textfielISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfielAuthor)
                                    .addComponent(textfielCategory))
                                .addGap(18, 18, 18)
                                .addComponent(lblImage))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(737, 737, 737)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(lblStudentIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLibrarianIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblBookIcon)
                    .addContainerGap(1841, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLibrarianIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(textfielAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textfielCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textfieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(textfieldfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textfieldPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textfielISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );

        lblManagmentSystem.setBackground(new java.awt.Color(153, 153, 153));
        lblManagmentSystem.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblManagmentSystem.setForeground(new java.awt.Color(255, 255, 255));

        btnNotify.setBackground(new java.awt.Color(56, 75, 147));
        btnNotify.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnNotify.setForeground(new java.awt.Color(255, 255, 255));
        btnNotify.setText("Notificarme");
        btnNotify.setBorder(null);

        btnBack.setBackground(new java.awt.Color(56, 75, 147));
        btnBack.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<- Regresar");
        btnBack.setBorder(null);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblManagmentSystem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(btnNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(btnNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(398, 398, 398)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblManagmentSystem))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //METODO PARA CERRAR LA VENTANA
    public void close() {
        this.setVisible(false);
        this.dispose();
    }
    //METODO QUE CAMBIA EL COLOR DEL MOUSE AL ENTRAR EN EL
    public void mouseEntered(JButton btn) {
        btn.setBackground(new Color(26,54,148));
    }
     //METODO QUE CAMBIA EL COLOR DEL MOUSE AL SALIR DE EL
    public void mouseExited(JButton btn) {
        btn.setBackground(new Color(56,75,147));
    }
//LLAMADA AL BOTON DE ATRAS
    public JButton getBtnBack() {
        return btnBack;
    }
//LLAMADA AL BOTON DE NOTIFICACION
    public JButton getBtnNotify() {
        return btnNotify;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNotify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLibrarianIcon;
    private javax.swing.JLabel lblManagmentSystem;
    private javax.swing.JLabel lblSelectTypeAccount;
    private javax.swing.JLabel lblStudentIcon;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JTextField textfielAuthor;
    private javax.swing.JTextField textfielCategory;
    private javax.swing.JTextField textfielISBN;
    private javax.swing.JTextField textfieldDate;
    private javax.swing.JTextField textfieldPublisher;
    private javax.swing.JTextField textfieldfStock;
    private javax.swing.JTextArea txtAreaDescription;
    // End of variables declaration//GEN-END:variables

}

package com.company.system.view;

import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RegisterDevolution extends javax.swing.JPanel {

    public RegisterDevolution() {
        initComponents();
        setVisible(true);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 =  new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        lblWelcome1 = new javax.swing.JLabel();
        jPanel3 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblbook3 = new javax.swing.JLabel();
        txtIdCardUser = new javax.swing.JTextField();
        btnSearchIdCard = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        lblNameStudent = new javax.swing.JLabel();
        lblbook5 = new javax.swing.JLabel();
        lblbook6 = new javax.swing.JLabel();
        lblbook7 = new javax.swing.JLabel();
        lblNameStudent1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInfoLoan = new javax.swing.JTextArea();
        btnRegisterDevolution = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);

        setPreferredSize(new java.awt.Dimension(1024, 738));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcome1.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        lblWelcome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome1.setText("Registrar nueva devolución");
        lblWelcome1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("JetBrains Mono", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(241, 241, 241));

        lblbook3.setBackground(new java.awt.Color(255, 255, 255));
        lblbook3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook3.setText("Escribe el #Cédula del estudiante:");
        lblbook3.setToolTipText("");
        lblbook3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtIdCardUser.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtIdCardUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearchIdCard.setBackground(new java.awt.Color(56, 75, 147));
        btnSearchIdCard.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSearchIdCard.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchIdCard.setText("Buscar");
        btnSearchIdCard.setBorder(null);

        lblNameStudent.setBackground(new java.awt.Color(255, 255, 255));
        lblNameStudent.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 13)); // NOI18N
        lblNameStudent.setToolTipText("");
        lblNameStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook5.setBackground(new java.awt.Color(255, 255, 255));
        lblbook5.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook5.setText("Nombres completos del estudiante:");
        lblbook5.setToolTipText("");
        lblbook5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook6.setBackground(new java.awt.Color(255, 255, 255));
        lblbook6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbook6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook6.setText("BUSCAR ESTUDIANTE");
        lblbook6.setToolTipText("");
        lblbook6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook7.setBackground(new java.awt.Color(255, 255, 255));
        lblbook7.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook7.setText("Informacion del libro prestado");
        lblbook7.setToolTipText("");
        lblbook7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNameStudent1.setBackground(new java.awt.Color(255, 255, 255));
        lblNameStudent1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 13)); // NOI18N
        lblNameStudent1.setToolTipText("");
        lblNameStudent1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAreaInfoLoan.setColumns(20);
        txtAreaInfoLoan.setLineWrap(true);
        txtAreaInfoLoan.setRows(5);
        jScrollPane1.setViewportView(txtAreaInfoLoan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblbook3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdCardUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblbook5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblbook7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(912, 912, 912)
                        .addComponent(lblNameStudent1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCardUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegisterDevolution.setBackground(new java.awt.Color(56, 75, 147));
        btnRegisterDevolution.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnRegisterDevolution.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterDevolution.setText("Registrar devolucion");
        btnRegisterDevolution.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegisterDevolution, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterDevolution, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void showMessage(String errorMessage, String title, int messageType ) {
        JOptionPane.showMessageDialog(this, errorMessage, title, messageType);
    }
    
    public void changeColor(JButton btn, Color color) {
        btn.setBackground(color);
    }

    public JButton getBtnRegisterDevolutio() {
        return btnRegisterDevolution;
    }

    public JButton getBtnSearchIdCard() {
        return btnSearchIdCard;
    }

    public JLabel getLblNameStudent() {
        return lblNameStudent;
    }
    
    public JTextField getTxtIdCardUser() {
        return txtIdCardUser;
    }

    public JTextArea getTxtAreaInfoLoan() {
        return txtAreaInfoLoan;
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisterDevolution;
    private javax.swing.JButton btnSearchIdCard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNameStudent;
    private javax.swing.JLabel lblNameStudent1;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JLabel lblbook3;
    private javax.swing.JLabel lblbook5;
    private javax.swing.JLabel lblbook6;
    private javax.swing.JLabel lblbook7;
    private javax.swing.JTextArea txtAreaInfoLoan;
    private javax.swing.JTextField txtIdCardUser;
    // End of variables declaration//GEN-END:variables
}

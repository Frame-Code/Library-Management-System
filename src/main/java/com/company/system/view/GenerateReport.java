package com.company.system.view;

import com.company.system.model.User;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class GenerateReport extends javax.swing.JPanel {
    public User user;
    public GenerateReport(User user) {
        this.user = user;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        lblGenerateReport = new javax.swing.JLabel();
        pnlInitialDate = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        txtLimit = new javax.swing.JTextField();
        lblbook8 = new javax.swing.JLabel();
        btnDowloadReport = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);

        contentPane.setBackground(new java.awt.Color(255, 255, 255));

        lblGenerateReport.setBackground(new java.awt.Color(255, 255, 255));
        lblGenerateReport.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        lblGenerateReport.setForeground(new java.awt.Color(0, 0, 0));
        lblGenerateReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerateReport.setText("Generar reporte");
        lblGenerateReport.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N

        pnlInitialDate.setBackground(new java.awt.Color(241, 241, 241));

        txtLimit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtLimit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblbook8.setBackground(new java.awt.Color(255, 255, 255));
        lblbook8.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook8.setForeground(new java.awt.Color(0, 0, 0));
        lblbook8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook8.setText("Escribe el numero maximo de resultados:");
        lblbook8.setToolTipText("");
        lblbook8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlInitialDateLayout = new javax.swing.GroupLayout(pnlInitialDate);
        pnlInitialDate.setLayout(pnlInitialDateLayout);
        pnlInitialDateLayout.setHorizontalGroup(
            pnlInitialDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialDateLayout.createSequentialGroup()
                .addComponent(lblbook8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlInitialDateLayout.setVerticalGroup(
            pnlInitialDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitialDateLayout.createSequentialGroup()
                .addGroup(pnlInitialDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbook8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDowloadReport.setBackground(new java.awt.Color(56, 75, 147));
        btnDowloadReport.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnDowloadReport.setForeground(new java.awt.Color(255, 255, 255));
        btnDowloadReport.setText("Descargar reporte");
        btnDowloadReport.setBorder(null);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInitialDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnDowloadReport, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(lblGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInitialDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDowloadReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 421, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnDowloadReport() {
        return btnDowloadReport;
    }

    public JLabel getLblGenerateReport() {
        return lblGenerateReport;
    }

    public JTextField getTxtLimit() {
        return txtLimit;
    }

    public User getUser() {
        return user;
    }


    public void showMessage(String text, String title, int type) {
        JOptionPane.showMessageDialog(null, text, title, type);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDowloadReport;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel lblGenerateReport;
    private javax.swing.JLabel lblbook8;
    private javax.swing.JPanel pnlInitialDate;
    private javax.swing.JTextField txtLimit;
    // End of variables declaration//GEN-END:variables
}

package com.company.system.view;

import com.company.system.model.User;
import com.company.system.view.components.LoadingDialog;
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

    public static String typeLatestBooksBorrowed = "Reporte de los ultimos libros prestados";
    public static String typeMostBorrowedBooks = "Reporte de libros mas prestados";
    public static String typeLoanHistoryByStudent = "Historal de prestamos por estudiante";
    private final String optionSelected;
    private final User librarian;
    private LoadingDialog loadingDialog;

    public GenerateReport(User librarian, String optionSelected) {
        this.librarian = librarian;
        this.optionSelected = optionSelected;
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
        pnlInitialDate1 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        txtIdCardUser = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        btnSearch = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        lblNameStudent = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

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

        pnlInitialDate1.setBackground(new java.awt.Color(241, 241, 241));

        txtIdCardUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtIdCardUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblId.setBackground(new java.awt.Color(255, 255, 255));
        lblId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblId.setText("Escribe la cedula del estudiante: ");
        lblId.setToolTipText("");
        lblId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSearch.setBackground(new java.awt.Color(56, 75, 147));
        btnSearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.setBorder(null);

        lblNameStudent.setBackground(new java.awt.Color(255, 255, 255));
        lblNameStudent.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 13)); // NOI18N
        lblNameStudent.setForeground(new java.awt.Color(0, 0, 0));
        lblNameStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameStudent.setText("(aqui aparecera el nombre del estudiante encontrado)");
        lblNameStudent.setToolTipText("");
        lblNameStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblName.setBackground(new java.awt.Color(255, 255, 255));
        lblName.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Nombres: ");
        lblName.setToolTipText("");
        lblName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlInitialDate1Layout = new javax.swing.GroupLayout(pnlInitialDate1);
        pnlInitialDate1.setLayout(pnlInitialDate1Layout);
        pnlInitialDate1Layout.setHorizontalGroup(
            pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialDate1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInitialDate1Layout.createSequentialGroup()
                        .addComponent(txtIdCardUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNameStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        pnlInitialDate1Layout.setVerticalGroup(
            pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitialDate1Layout.createSequentialGroup()
                .addGroup(pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdCardUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInitialDate1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInitialDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameStudent))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInitialDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInitialDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnDowloadReport, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(lblGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInitialDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInitialDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDowloadReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
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

    public void setActiveOptions() {
        if (optionSelected.equals(typeLatestBooksBorrowed) || optionSelected.equals(typeMostBorrowedBooks)) {
            txtIdCardUser.setEnabled(false);
            btnSearch.setEnabled(false);
            btnSearch.setBackground(new Color(168, 168, 168));
            lblNameStudent.setEnabled(false);
            lblNameStudent.setBackground(new Color(168, 168, 168));
            lblId.setBackground(new Color(168, 168, 168));
            lblId.setEnabled(false);
            lblName.setBackground(new Color(168, 168, 168));
            lblName.setEnabled(false);

        } else {
            txtIdCardUser.setEnabled(true);
            btnSearch.setEnabled(true);
            btnSearch.setBackground(new Color(56, 75, 147));
            lblNameStudent.setEnabled(false);
            lblNameStudent.setBackground(new Color(0, 0, 0));
            lblId.setBackground(new Color(0, 0, 0));
            lblName.setBackground(new Color(0, 0, 0));
        }
    }

    public void paintButton(JButton btn, Color color) {
        if (btn.isEnabled()) {
            btn.setBackground(color);
        }
    }

    public void cleanFields() {
        txtIdCardUser.setText("");
        txtLimit.setText("");
    }

    public JButton getBtnDowloadReport() {
        return btnDowloadReport;
    }

    public JLabel getLblGenerateReport() {
        return lblGenerateReport;
    }

    public JTextField getTxtLimit() {
        return txtLimit;
    }

    public User getLibrarian() {
        return librarian;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JLabel getLblNameStudent() {
        return lblNameStudent;
    }

    public JTextField getTxtIdCardUser() {
        return txtIdCardUser;
    }

    public String getOptionSelected() {
        return optionSelected;
    }

    public LoadingDialog getLoadingDialog() {
        return loadingDialog;
    }

    public void showLoadingDialog() {
        this.loadingDialog = new LoadingDialog("Generando reporte...", "Generando reporte, por favor espere...");
        loadingDialog.setVisible(true);
    }

    public void hideLoadingDialog() {
        loadingDialog.setVisible(false);
        loadingDialog.dispose();
    }

    public void showMessage(String text, String title, int type) {
        JOptionPane.showMessageDialog(null, text, title, type);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDowloadReport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel lblGenerateReport;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameStudent;
    private javax.swing.JLabel lblbook8;
    private javax.swing.JPanel pnlInitialDate;
    private javax.swing.JPanel pnlInitialDate1;
    private javax.swing.JTextField txtIdCardUser;
    private javax.swing.JTextField txtLimit;
    // End of variables declaration//GEN-END:variables
}

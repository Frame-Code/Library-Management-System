package com.company.system.view;

import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class HistoryFines extends javax.swing.JPanel implements TableModel {
    private final String[] columnNames = new String[]{"Id", "Fecha de registro", "Mensaje", "Fecha limite"};

    public HistoryFines() {
        initComponents();
        setVisible(true);
        uploadColumnTable();
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
        btnGuardar = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        btnClean = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        jPanel5 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblbook8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFines = new javax.swing.JTable();
        jPanel4 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        txtIdFine = new javax.swing.JTextField();
        lblbook4 = new javax.swing.JLabel();
        lblbook7 = new javax.swing.JLabel();
        lblbook9 = new javax.swing.JLabel();
        txtRegisterDay = new javax.swing.JTextField();
        lblbook10 = new javax.swing.JLabel();
        txtDeadLineDay = new javax.swing.JTextField();
        lblbook11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMessage = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1024, 738));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcome1.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        lblWelcome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome1.setText("Ver multas de un estudiante");
        lblWelcome1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdCardUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblbook5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCardUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(56, 75, 147));
        btnGuardar.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);

        btnClean.setBackground(new java.awt.Color(56, 75, 147));
        btnClean.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnClean.setForeground(new java.awt.Color(255, 255, 255));
        btnClean.setText("Limpiar");
        btnClean.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(241, 241, 241));

        lblbook8.setBackground(new java.awt.Color(255, 255, 255));
        lblbook8.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook8.setText("Historial de multas del estudiante");
        lblbook8.setToolTipText("");
        lblbook8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblFines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFines);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblbook8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(241, 241, 241));

        txtIdFine.setEditable(false);
        txtIdFine.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtIdFine.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblbook4.setBackground(new java.awt.Color(255, 255, 255));
        lblbook4.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook4.setText("Id:");
        lblbook4.setToolTipText("");
        lblbook4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook7.setBackground(new java.awt.Color(255, 255, 255));
        lblbook7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbook7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook7.setText("INFORMACION");
        lblbook7.setToolTipText("");
        lblbook7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook9.setBackground(new java.awt.Color(255, 255, 255));
        lblbook9.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook9.setText("Dia de registro:");
        lblbook9.setToolTipText("");
        lblbook9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtRegisterDay.setEditable(false);
        txtRegisterDay.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtRegisterDay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblbook10.setBackground(new java.awt.Color(255, 255, 255));
        lblbook10.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook10.setText("Fecha limite: ");
        lblbook10.setToolTipText("");
        lblbook10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDeadLineDay.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtDeadLineDay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblbook11.setBackground(new java.awt.Color(255, 255, 255));
        lblbook11.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook11.setText("Mensaje:");
        lblbook11.setToolTipText("");
        lblbook11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAreaMessage.setColumns(20);
        txtAreaMessage.setRows(5);
        jScrollPane2.setViewportView(txtAreaMessage);

        jLabel10.setText("Dia:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(205, 205, 205));
        jLabel13.setText("(número)");

        jLabel11.setText("Mes:");

        cmbMonth.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero ", "Marzo ", "Abril ", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre ", "Diciembre" }));
        cmbMonth.setBorder(null);

        jLabel12.setText("Año:");

        txtYear.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtYear.setToolTipText("");
        txtYear.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(205, 205, 205));
        jLabel14.setText("(número)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblbook11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(140, 140, 140))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblbook9)
                            .addComponent(lblbook4)
                            .addComponent(lblbook10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegisterDay)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(txtDeadLineDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addGap(65, 65, 65)
                                            .addComponent(jLabel12)
                                            .addGap(23, 23, 23)))
                                    .addComponent(txtIdFine, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 19, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbook4))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblbook9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegisterDay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblbook10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeadLineDay, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblWelcome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
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

    private void uploadColumnTable() {
        tblFines.setModel(getBasicTableModel(columnNames));
    }
    
    public void cleanTable() {
        DefaultTableModel df = (DefaultTableModel) getTblFines().getModel();
        df.setRowCount(0);
        tblFines.setModel(df);
    }

    public void showMessage(String errorMessage, String title, int messageType) {
        JOptionPane.showMessageDialog(this, errorMessage, title, messageType);
    }

    public void changeColor(JButton btn, Color color) {
        btn.setBackground(color);
    }

    public String[] getColumnNames() {
        return columnNames;
    }
    
    public JButton getBtnClean() {
        return btnClean;
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

    public JComboBox<String> getCmbMonth() {
        return cmbMonth;
    }

    public void setCmbMonth(JComboBox<String> cmbMonth) {
        this.cmbMonth = cmbMonth;
    }

    public JTextArea getTxtAreaMessage() {
        return txtAreaMessage;
    }

    public void setTxtAreaMessage(JTextArea txtAreaMessage) {
        this.txtAreaMessage = txtAreaMessage;
    }

    public JTextField getTxtDeadLineDay() {
        return txtDeadLineDay;
    }

    public void setTxtDeadLineDay(JTextField txtDeadLineDay) {
        this.txtDeadLineDay = txtDeadLineDay;
    }

    public JTextField getTxtIdFine() {
        return txtIdFine;
    }

    public void setTxtIdFine(JTextField txtIdFine) {
        this.txtIdFine = txtIdFine;
    }

    public JTextField getTxtRegisterDay() {
        return txtRegisterDay;
    }

    public void setTxtRegisterDay(JTextField txtRegisterDay) {
        this.txtRegisterDay = txtRegisterDay;
    }

    public JTextField getTxtYear() {
        return txtYear;
    }

    public void setTxtYear(JTextField txtYear) {
        this.txtYear = txtYear;
    }

    public JTable getTblFines() {
        return tblFines;
    }

    public ListSelectionModel getModelSelectionOfTable() {
        return tblFines.getSelectionModel();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSearchIdCard;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNameStudent;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JLabel lblbook10;
    private javax.swing.JLabel lblbook11;
    private javax.swing.JLabel lblbook3;
    private javax.swing.JLabel lblbook4;
    private javax.swing.JLabel lblbook5;
    private javax.swing.JLabel lblbook6;
    private javax.swing.JLabel lblbook7;
    private javax.swing.JLabel lblbook8;
    private javax.swing.JLabel lblbook9;
    private javax.swing.JTable tblFines;
    private javax.swing.JTextArea txtAreaMessage;
    private javax.swing.JTextField txtDeadLineDay;
    private javax.swing.JTextField txtIdCardUser;
    private javax.swing.JTextField txtIdFine;
    private javax.swing.JTextField txtRegisterDay;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}

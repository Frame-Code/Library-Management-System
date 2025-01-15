package com.company.system.view;


import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedButtonWithShadow;
import com.company.system.view.components.RoundedPanelWithShadow;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ariel
 */
public class SelectAutors extends javax.swing.JFrame {

    private final String[] columnNames = new String[]{"Seleccionar", "id", "Nombres del autor"};
    private List<Long> idAuthors;
    private RegisterBook registerBook;

    public SelectAutors(RegisterBook registerBook) {
        this.idAuthors = new ArrayList<>();
        this.registerBook = registerBook;
        initComponents();
        setResizable(true);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        contentPane = new BackgroundPanel("src/main/resources/images/Background_login.png");
        pnlBackground = new RoundedPanelWithShadow(30, new Color(0, 0, 0, 100), 2);
        lblBookIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        jPanel2 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblbook = new javax.swing.JLabel();
        txtNames = new javax.swing.JTextField();
        btnSearchName = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        lblBookTittle = new javax.swing.JLabel();
        lblbook7 = new javax.swing.JLabel();
        jPanel6 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblbook9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAuthors = new javax.swing.JTable();
        btnSave = new RoundedButtonWithShadow("Iniciar sesion", 7, new Color(0, 0, 0, 100), 4);
        jPanel4 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblbook10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaAuthors = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(79, 90, 100));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(241, 241, 241));

        lblbook.setBackground(new java.awt.Color(255, 255, 255));
        lblbook.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook.setText("Escribe el nombre del autor:");
        lblbook.setToolTipText("");
        lblbook.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtNames.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        txtNames.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearchName.setBackground(new java.awt.Color(56, 75, 147));
        btnSearchName.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSearchName.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchName.setText("Buscar");
        btnSearchName.setBorder(null);

        lblBookTittle.setBackground(new java.awt.Color(255, 255, 255));
        lblBookTittle.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 13)); // NOI18N
        lblBookTittle.setToolTipText("");
        lblBookTittle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblbook7.setBackground(new java.awt.Color(255, 255, 255));
        lblbook7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbook7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook7.setText("BUSCAR AUTORES");
        lblbook7.setToolTipText("");
        lblbook7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNames)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBookTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblbook, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNames, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(lblBookTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(241, 241, 241));

        lblbook9.setBackground(new java.awt.Color(255, 255, 255));
        lblbook9.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        lblbook9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook9.setText("Autores registrados");
        lblbook9.setToolTipText("");
        lblbook9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblAuthors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblAuthors);

        btnSave.setBackground(new java.awt.Color(56, 75, 147));
        btnSave.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblbook9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(241, 241, 241));

        lblbook10.setBackground(new java.awt.Color(255, 255, 255));
        lblbook10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbook10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook10.setText("Autores seleccionados");
        lblbook10.setToolTipText("");
        lblbook10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAreaAuthors.setColumns(20);
        txtAreaAuthors.setLineWrap(true);
        txtAreaAuthors.setRows(5);
        jScrollPane3.setViewportView(txtAreaAuthors);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblbook10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBookIcon))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblBookIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    public void showMessage(String errorMessage, String title, int messageType) {
        JOptionPane.showMessageDialog(this, errorMessage, title, messageType);
    }

    public JButton getBtnSearchName() {
        return btnSearchName;
    }

    public JTable getTblAuthors() {
        return tblAuthors;
    }

    public JTextArea getTxtAreaAuthors() {
        return txtAreaAuthors;
    }

    public JTextField getTxtNames() {
        return txtNames;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public List<Long> getIdAuthors() {
        return idAuthors;
    }

    public JButton getBtnSave() {
        return btnSave;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchName;
    private javax.swing.JPanel contentPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblBookTittle;
    private javax.swing.JLabel lblbook;
    private javax.swing.JLabel lblbook10;
    private javax.swing.JLabel lblbook7;
    private javax.swing.JLabel lblbook8;
    private javax.swing.JLabel lblbook9;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTable tblAuthors;
    private javax.swing.JTable tblLoans;
    private javax.swing.JTextArea txtAreaAuthors;
    private javax.swing.JTextField txtNames;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.company.system.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CategoryBooks extends JInternalFrame {

    public CategoryBooks(String categoryName) {
        super(categoryName, true, true, true, true);
        initComponents();
        setTitle("Categoría: " + categoryName);
        setSize(800, 597);
        setLayout(new BorderLayout());

        // Crear el panel de etiquetas (JLabels) en lugar de botones
        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        addLabels(categoryName, panel);

        // Configurar el tamaño preferido del panel para asegurarse de que la barra de desplazamiento aparezca si es necesario
        panel.setPreferredSize(new Dimension(500, 800)); // Ajusta la altura según sea necesario

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addLabels(String categoryName, JPanel panel) {
        for (int i = 1; i <= 16; i++) {
            // Reemplazar JButton con buttonDesign (un JPanel que contiene JLabel)
            buttonDesign label = new buttonDesign();
            label.setText(categoryName + " Libro " + i); // Establecer el texto del JLabel dentro de buttonDesign
            panel.add(label);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }
}
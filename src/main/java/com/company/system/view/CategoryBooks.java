/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.company.system.view;

import com.company.system.model.Author;
import com.company.system.model.Book;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CategoryBooks extends JInternalFrame {
    private JPanel panel;
    
    public CategoryBooks(String categoryName) {
        super(categoryName, true, true, true, true);
        initComponents();
        setTitle("Categoría: " + categoryName);
        setSize(800, 597);
        setLayout(new BorderLayout());

        // Crear el panel de etiquetas (JLabels) en lugar de botones
        panel = new JPanel(new GridLayout(4, 4, 10, 10));
//        addLabels(categoryName, panel);

        // Configurar el tamaño preferido del panel para asegurarse de que la barra de desplazamiento aparezca si es necesario
        panel.setPreferredSize(new Dimension(500, 800)); // Ajusta la altura según sea necesario

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    
    public void addBooks(List<Book> books) {
        books.forEach(book -> {
            ButtonDesign label = new ButtonDesign();
            label.getLblTitle().setText("Titulo: " + book.getTitle());
            label.getLblTitle().setFont(new Font("DejaVu Sans Condensed", 1, 14));
            String authorsString = "Autores: ";
            for (Author author : book.getAuthors()) {
                authorsString += author.getSurNames() + ", ";
            }
            label.getLblAuthors().setText(authorsString);
            label.getLblPublihser().setText("Editorial: " + book.getPublisher().getName());
            this.panel.add(label);
        });
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
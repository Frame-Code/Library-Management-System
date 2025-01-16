package com.company.system.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ariel
 */
public class Internalframebook extends javax.swing.JInternalFrame {
private JPanel panel;
    

    public Internalframebook(String NameInternalframe) {
        super(NameInternalframe, true, true, true, true);

        initComponents();
        setTitle(NameInternalframe);
        setSize(800, 597);
        setLayout(new BorderLayout());
        
        panel = new JPanel(new GridLayout(4,4,10,10));
        panel.setPreferredSize(new Dimension(500,800));
        JScrollPane Scrollpane = new JScrollPane(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

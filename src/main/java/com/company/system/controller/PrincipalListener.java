/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.system.controller;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalListener implements ActionListener {

    private JDesktopPane desktopPane;

    public PrincipalListener(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource(); // Obtener el item del menú que disparó el evento
        String title = menuItem.getText(); // Usar el texto del menú como título del frame

        // Crear un nuevo JInternalFrame
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        internalFrame.setSize(600, 600);
        internalFrame.setLayout(new GridLayout(4, 4, 10, 10)); // Configurar la cuadrícula 4x4 con espacio entre botones

        // Agregar los botones al internalFrame
        for (int i = 1; i <= 16; i++) {
            JButton button = new JButton("");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
            });
            internalFrame.add(button);
        }

        // Agregar el internalFrame al JDesktopPane y hacer que sea visible
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);

        // Intentar seleccionar el internalFrame (hace que sea visible en la parte frontal)
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }
}

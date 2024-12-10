/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.system.controller;

import com.company.system.view.ButtonDesign;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author jandr
 */
public class ButtonDesignListener extends MouseAdapter {

    private final ButtonDesign buttonDesign;

    public ButtonDesignListener(ButtonDesign buttonDesign) {
        this.buttonDesign = buttonDesign;

        // Asegurarse de que el fondo es visible
        buttonDesign.setOpaque(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        buttonDesign.setBackground(new Color(200, 230, 255)); // Cambiar a un color más claro
        buttonDesign.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        buttonDesign.setBackground(Color.WHITE); // Restaurar el color original
        buttonDesign.repaint();
    }
}
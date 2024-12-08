package com.company.system.view.components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Cargar la imagen
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

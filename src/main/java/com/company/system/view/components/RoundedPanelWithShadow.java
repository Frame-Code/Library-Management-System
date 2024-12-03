package com.company.system.view.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanelWithShadow extends JPanel{
    private int cornerRadius;
    private Color shadowColor;
    private int shadowSize;

    public RoundedPanelWithShadow(int cornerRadius, Color shadowColor, int shadowSize) {
        this.cornerRadius = cornerRadius;
        this.shadowColor = shadowColor;
        this.shadowSize = shadowSize;
        setOpaque(false); // Hace que el fondo sea transparente para dibujar la sombra
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Mejora el renderizado para sombras suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la sombra
        g2.setColor(shadowColor);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, cornerRadius, cornerRadius);

        // Dibuja el fondo del panel
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, cornerRadius, cornerRadius);

        g2.dispose();
        super.paintComponent(g); // Para asegurar que otros componentes hijos se rendericen correctamente
    }
}

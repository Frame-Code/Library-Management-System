package com.company.system.view.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class RoundedButtonWithShadow extends JButton{
    private int cornerRadius;
    private Color shadowColor;
    private int shadowSize;

    public RoundedButtonWithShadow(String text, int cornerRadius, Color shadowColor, int shadowSize) {
        super(text);
        this.cornerRadius = cornerRadius;
        this.shadowColor = shadowColor;
        this.shadowSize = shadowSize;
        setFocusPainted(false); // Elimina el borde de enfoque
        setContentAreaFilled(false); // Evita el renderizado predeterminado
        setBorderPainted(false); // Elimina el borde predeterminado
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Mejora el renderizado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la sombra
        g2.setColor(shadowColor);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, cornerRadius, cornerRadius);

        // Dibuja el fondo del botón
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, cornerRadius, cornerRadius);

        // Dibuja el texto del botón
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - shadowSize);

        g2.dispose();
    }
}

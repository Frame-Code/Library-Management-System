package com.company.system.view;

import com.company.system.view.components.RoundedPanelWithShadow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jandr
 */
public class ButtonDesign extends RoundedPanelWithShadow {

    private JLabel lblIcon;
    private JLabel lblTitle;
    private JLabel lblAuthors;
    private JLabel lblPublihser;
    private JPanel labelPanel;

    public ButtonDesign() {
        super(15, Color.black, 1);
        initComponents();
    }

    private void initComponents() {
        labelPanel = new JPanel(new GridLayout(0,1));
        labelPanel.setOpaque(false);
        String imagePath = "/images/openBook.png";
        ImageIcon icon = new ImageIcon(ButtonDesign.class.getResource(imagePath));
        lblIcon = new JLabel(icon);
        lblTitle = new JLabel("Title: ");
        lblAuthors = new JLabel("Autores: ");
        lblPublihser = new JLabel("Editorial: ");
        lblIcon.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblAuthors.setHorizontalAlignment(JLabel.CENTER);
        lblPublihser.setHorizontalAlignment(JLabel.CENTER);
        lblIcon.setOpaque(false); 
        lblTitle.setOpaque(false); 
        lblAuthors.setOpaque(false); 
        lblPublihser.setOpaque(false); 
        
        // Establecer el tamaño del panel
        setPreferredSize(new Dimension(100, 100)); // Esto asegura que el panel sea cuadrado
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        labelPanel.add(lblIcon);
        labelPanel.add(lblTitle);
        labelPanel.add(lblAuthors);
        labelPanel.add(lblPublihser);
        
        add(labelPanel, BorderLayout.CENTER);
        
        // Establecer borde circular cuando pintamos el panel
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Deja espacio para que se vea el borde circular
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JLabel getLblAuthors() {
        return lblAuthors;
    }

    public void setLblAuthors(JLabel lblAuthors) {
        this.lblAuthors = lblAuthors;
    }

    public JLabel getLblPublihser() {
        return lblPublihser;
    }

    public void setLblPublihser(JLabel lblPublihser) {
        this.lblPublihser = lblPublihser;
    }


}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.system.view;

<<<<<<< HEAD
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

=======
import javax.swing.JLabel;
import javax.swing.JPanel;
>>>>>>> 2969f9a36ad030732eff09219247d856a2169e6f
/**
 *
 * @author jandr
 */
public class buttonDesign extends JPanel {
<<<<<<< HEAD

=======
    private JLabel lblTitle;
    private JLabel lblicon;
>>>>>>> 2969f9a36ad030732eff09219247d856a2169e6f
    private JLabel lblDescrip;

    /**
     * Creates new form buttonDesign
     */
    public buttonDesign() {
        initComponents();
        setupListeners(); // Configurar los listeners para la interacción
    }

    private void initComponents() {
<<<<<<< HEAD
=======
        lblTitle = new JLabel();
        lblicon = new JLabel();
>>>>>>> 2969f9a36ad030732eff09219247d856a2169e6f
        lblDescrip = new JLabel();
        lblDescrip.setHorizontalAlignment(JLabel.CENTER);
        lblDescrip.setOpaque(true); // Necesario para ver el color de fondo
        add(lblDescrip);

        // Establecer el tamaño del panel
        setPreferredSize(new Dimension(100, 100)); // Esto asegura que el panel sea cuadrado
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(lblDescrip, BorderLayout.CENTER);

        // Establecer borde circular cuando pintamos el panel
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Deja espacio para que se vea el borde circular
    }

    private void setupListeners() {
<<<<<<< HEAD
        // Aquí puedes agregar los listeners para manejar eventos, como el clic
        lblDescrip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE); // Restaurar el color de fondo al salir
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Acción cuando se hace clic en el JLabel
                System.out.println("Etiqueta clickeada: " + lblDescrip.getText());
            }
        });
    }

    public void setText(String text) {
        lblDescrip.setText(text); // Establecer el texto de la etiqueta
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Crear un borde circular para el panel
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Aquí creamos el borde circular, ajustando el radio
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50); // Radio 50 para bordes redondeados

        // Dibuja el borde en negro
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2)); // Grosor del borde
        g2d.drawRoundRect(0, 0, getWidth(), getHeight(), 50, 50); // Radio 50 para bordes redondeados
=======
        // Agregar los listeners para las etiquetas
        //lblicon.addMouseListener(new LabelMouseListener(this));
        //lblDescrip.addMouseListener(new LabelMouseListener(this));
>>>>>>> 2969f9a36ad030732eff09219247d856a2169e6f
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    
}
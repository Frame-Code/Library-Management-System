package com.company.system.controller;

import com.company.system.view.InfoLibroWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Ariel Reyes Domo
 */
//IMPLEMENTACION DE ActionListener Y MouseListener PARA MANEJAR LOS EVENTOS DE ESTOS MISMOS
public class InfoLibroWindowListener implements ActionListener, MouseListener {

    //SE REFERENCIA AL JFRAME INFOLIBROWINDOW
    private final InfoLibroWindow frmLibrowindow;

    //SE INICIALIZA LA REFERENCIA A INFOLIBROWINDOW Y SE AGREGA LOS LISTENERS
    public InfoLibroWindowListener(InfoLibroWindow frmLibrowindow) {
        this.frmLibrowindow = frmLibrowindow;
        addListeners();
    }

    private void addListeners() {

        // SE AGREGA ActionListener Y MouseListener AL BOTON DE NOTIFICACIONES
        frmLibrowindow.getBtnNotify().addActionListener(this);
        frmLibrowindow.getBtnNotify().addMouseListener(this);

        // SE AGREGA ActionListener Y MouseListener AL BOTON DE ATRAS
        frmLibrowindow.getBtnBack().addActionListener(this);
        frmLibrowindow.getBtnBack().addMouseListener(this);
    }
//METODO PARA MANEJAR LA ACCION DE LOS BOTONES

    @Override
    public void actionPerformed(ActionEvent e) {

        //VERIFICA SI SE ACCIONO EL BOTON DE NOTIFICACION
        if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            //VERIFICA SI SE ACCIONO EL BOTON DE ATRAS
        } else if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.close();
        }
    }
//METODO PARA CAMBIAR EL COLOR O ALGO CUANDO PASAMOS EL MOUSE POR EL BOTON
    //DE NOTIFICACION O EL BOTON ATRAS

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getBtnNotify());
        } else if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseEntered(frmLibrowindow.getBtnBack());
        }
    }
//METODO PARA CAMBIAR EL COLOR O ALGO CUANDO SACAMOS EL MOUSE DEL BOTON
    //DE NOTIFICACION O EL BOTON ATRAS

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLibrowindow.getBtnNotify()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getBtnNotify());
        } else if (e.getSource() == frmLibrowindow.getBtnBack()) {
            frmLibrowindow.mouseExited(frmLibrowindow.getBtnBack());
        }
    }
//METODO PARA MANEJAR EL CLICK EN EL BOTON (NO USADO EN MI TRABAJO POR AHORA)

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    //METODO PARA MANEJAR CUANDO TENEMOS PRESIONADO EL BOTON (NO USADO EN MI TRABAJO POR AHORA)
    @Override
    public void mousePressed(MouseEvent e) {
    }

    //METODO PARA MANEJAR CUANDO SOLTAMOS EL BOTON (NO USADO EN MI TRABAJO POR AHORA)
    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

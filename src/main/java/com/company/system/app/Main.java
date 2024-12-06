package com.company.system.app;

import com.company.system.controller.InfoLibroWindowListener;
import com.company.system.view.InfoLibroWindow;


public class Main {

    public static void main(String[] args) {
        InfoLibroWindow frmInitial = new InfoLibroWindow();
        frmInitial.setVisible(true);
        InfoLibroWindowListener frmInitialListener = new InfoLibroWindowListener(frmInitial);
        System.out.println("prueba");
    }
}

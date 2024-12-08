package com.company.system.app;

import com.company.system.controller.InfoLibroWindowListener;
import com.company.system.view.InfoLibroWindow;


public class Main {

    public static void main(String[] args) {
        InfoLibroWindow frmLibroWindow = new InfoLibroWindow();
        frmLibroWindow.setVisible(true);
        new InfoLibroWindowListener(frmLibroWindow);
    }
}

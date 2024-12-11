package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.view.InitialWindow;

public class Main {
    public static void main(String[] args) {
        InitialWindow frmInitial = new InitialWindow();
        frmInitial.setVisible(true);
        new InitialWindowListener(frmInitial);

        //RegisterStudent register = new RegisterStudent();
        //register.setVisible(true);
    }
}

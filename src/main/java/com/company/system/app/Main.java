package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.view.InitialWindow;
import com.company.system.view.LibraryHome;


public class Main {
    public static void main(String[] args) {
        //InitialWindow frmInitial = new InitialWindow();
        //frmInitial.setVisible(true);
        //new InitialWindowListener(frmInitial);
        LibraryHome frm = new LibraryHome();
        frm.setVisible(true);
    }
}

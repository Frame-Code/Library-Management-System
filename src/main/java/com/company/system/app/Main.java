package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.service.UserService;
import com.company.system.view.InitialWindow;
import com.company.system.view.LibraryHome;

import com.company.system.controller.InfoLibroWindowListener;
import com.company.system.view.InfoLibroWindow;

public class Main {
    public static void main(String[] args) {
        InitialWindow frmInitial = new InitialWindow();
        new InitialWindowListener(frmInitial, new UserService());
        frmInitial.setVisible(true);
        //LibraryHome frm = new LibraryHome();
        //frm.setVisible(true);
    }
}

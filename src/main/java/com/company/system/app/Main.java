    package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.controller.LibraryHomeListener;
import com.company.system.service.UserService;
import com.company.system.view.InitialWindow;
import com.company.system.view.LibraryHome;

public class Main {
    public static void main(String[] args) {
        //InitialWindow frmInitial = new InitialWindow();
        //new InitialWindowListener(frmInitial, new UserService());
        //frmInitial.setVisible(true);
        LibraryHome frm = new LibraryHome(null);
        new LibraryHomeListener(frm, new UserService());
        frm.setVisible(true);
    }
}

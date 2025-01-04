package com.company.system.app;

import com.company.system.controller.LibrarianWindowListener;
import com.company.system.view.LibrarianWindow;

public class Main {

    public static void main(String[] args) {

        LibrarianWindow lb = new LibrarianWindow();
        new LibrarianWindowListener(lb);    
        lb.setVisible(true);
    }
}

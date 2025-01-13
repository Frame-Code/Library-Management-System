package com.company.system.app;

import com.company.system.controller.LibrarianWindowListener;
import com.company.system.view.LibrarianWindow;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public class App {
    private static LibrarianWindow lb;
    
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                lb = new LibrarianWindow();
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        new LibrarianWindowListener(lb);
        lb.setVisible(true);
    }
    
}

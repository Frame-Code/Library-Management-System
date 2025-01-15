package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.service.UserService;
import com.company.system.view.InitialWindow;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public class App {
    private static InitialWindow iw;
    
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                iw = new InitialWindow();
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        new InitialWindowListener(iw, new UserService());
        iw.setVisible(true);
    }
    
}

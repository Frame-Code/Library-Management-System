package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.dao.impl.RoleDaoImpl;
import com.company.system.model.Role;
import com.company.system.view.InitialWindow;

public class Main {

    public static void main(String[] args) {
        InitialWindow frmInitial = new InitialWindow();
        frmInitial.setVisible(true);
        InitialWindowListener frmInitialListener = new InitialWindowListener(frmInitial);

                Role role = new RoleDaoImpl().findById(1L);
        System.out.println(role);
    }
}

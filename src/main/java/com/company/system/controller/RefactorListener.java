package com.company.system.controller;

import com.company.system.view.CategoryBooks;
import com.company.system.view.Refactor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class RefactorListener implements ActionListener{
    private final Refactor frmRefactor;

    public RefactorListener(Refactor frmRefactor) {
        this.frmRefactor = frmRefactor;
        addListeners();
    }
    
    private void addListeners() {
        frmRefactor.getBtnCategoria().addActionListener(this);
        frmRefactor.getSubOpcion1().addActionListener(this);
        frmRefactor.getSubOpcion2().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmRefactor.getBtnCategoria()) {
            frmRefactor.getMenuContextual().show(frmRefactor.getBtnCategoria(), frmRefactor.getBtnCategoria().getWidth(), 0);
            System.out.println("Se ejectu");
        } else if (e.getSource() == frmRefactor.getSubOpcion1()) {
            frmRefactor.addToDesktopPane(new CategoryBooks());
        }
    }
    

}

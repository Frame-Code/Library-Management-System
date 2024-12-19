package com.company.system.controller;

import com.company.system.view.LibrarianWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author HP240
 */
public class LibrarianWindowListener implements ActionListener{
    private LibrarianWindow frmLibraianWindow;
    
    public void LibrarianWindowListener(LibrarianWindow frmLibrarianWindow){
        this.frmLibraianWindow = frmLibrarianWindow;
        addListener();
    }
    
    public void addListener(){
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}

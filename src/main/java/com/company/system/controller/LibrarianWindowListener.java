/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

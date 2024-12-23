/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.system.controller;

import com.company.system.view.RegisterBook;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author HP240
 */
public class RegisterBookListener implements ActionListener, MouseListener, KeyListener{
    private RegisterBook lblRegisterBook;
    
    public RegisterBookListener(RegisterBook lblRegisterBook){
        this.lblRegisterBook = lblRegisterBook;
        addListener();
    }
    
    public void addListener(){
        lblRegisterBook.getBtnRegisterBook().addActionListener(this);
        lblRegisterBook.getBtnRegisterBook().addMouseListener(this);
        lblRegisterBook.getBtnRegisterBook().addKeyListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lblRegisterBook.getBtnRegisterBook()) {
            lblRegisterBook.mouseEvent(lblRegisterBook.getBtnRegisterBook(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lblRegisterBook.getBtnRegisterBook()) {
            lblRegisterBook.mouseEvent(lblRegisterBook.getBtnRegisterBook(), Utils.btnExited);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

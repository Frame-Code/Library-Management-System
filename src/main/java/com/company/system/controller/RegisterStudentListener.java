/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.system.controller;

import com.company.system.view.RegisterStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author HP240
 */
public class RegisterStudentListener implements ActionListener, MouseListener{
    private RegisterStudent frmRegisterStudent;
    
    public RegisterStudentListener(RegisterStudent frmRegisterStudent){
        this.frmRegisterStudent = frmRegisterStudent;
        addListener();
    }
    public void addListener(){
        frmRegisterStudent.getBtnAtrasRegistrar().addActionListener(this);
        frmRegisterStudent.getBtnAtrasRegistrar().addMouseListener(this);
        frmRegisterStudent.getBtnRegistrar().addActionListener(this);
        frmRegisterStudent.getBtnRegistrar().addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmRegisterStudent.getBtnAtrasRegistrar()){
            frmRegisterStudent.back();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

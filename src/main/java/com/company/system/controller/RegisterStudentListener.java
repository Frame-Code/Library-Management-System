/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.system.controller;

import com.company.system.view.RegisterStudent;
import com.company.system.view.components.Utils;
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
        frmRegisterStudent.getBtnBackRegister().addActionListener(this);
        frmRegisterStudent.getBtnBackRegister().addMouseListener(this);
        frmRegisterStudent.getBtnRegistrar().addActionListener(this);
        frmRegisterStudent.getBtnRegistrar().addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmRegisterStudent.getBtnBackRegister()){
            frmRegisterStudent.back();
        }else
            if(e.getSource() == frmRegisterStudent.getBtnRegistrar()){
                frmRegisterStudent.getTxtNombres().setText("");
                frmRegisterStudent.getTxtApellidos().setText("");
                frmRegisterStudent.getTxtCedula().setText("");
                frmRegisterStudent.getTxtCorreo().setText("");
                frmRegisterStudent.getTxtNacimiento().setText("");
                frmRegisterStudent.getPswContrasena().setText("");
                frmRegisterStudent.getPswConfirmarContrasena().setText("");
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
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnEntered);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegistrar()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegistrar(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmRegisterStudent.getBtnBackRegister()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnBackRegister(), Utils.btnExited);
        } else if (e.getSource() == frmRegisterStudent.getBtnRegistrar()) {
            frmRegisterStudent.mouseEvent(frmRegisterStudent.getBtnRegistrar(), Utils.btnExited);
        }
    }
    
}

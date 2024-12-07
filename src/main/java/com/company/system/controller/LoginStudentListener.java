
package com.company.system.controller;

import com.company.system.view.InitialWindow;
import com.company.system.view.LoginStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author HP240
 */
public class LoginStudentListener implements ActionListener, MouseListener{
    private LoginStudent frmLogin;
    
    public void LoginStudentListener(LoginStudent frmLogin){
        this.frmLogin = frmLogin;
        addListeners();
    }
    
    public void addListeners(){
        frmLogin.getBtnIniciarSesion().addActionListener(this);
        frmLogin.getBtnIniciarSesion().addMouseListener(this);
        frmLogin.getBtnAtrasLogin().addActionListener(this);
        frmLogin.getBtnAtrasLogin().addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.getBtnAtrasLogin()) {
            frmLogin.back();
        
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

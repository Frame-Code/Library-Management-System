
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
    private final LoginStudent frmLogin;
    
    public LoginStudentListener(LoginStudent frmLogin){
        this.frmLogin = frmLogin;
        addListeners();
    }
    
    private void addListeners(){
        frmLogin.getBtnLogin().addActionListener(this);
        frmLogin.getBtnLogin().addMouseListener(this);
        frmLogin.getBtnBack().addActionListener(this);
        frmLogin.getBtnBack().addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.back();
        }else
            if (e.getSource() == frmLogin.getBtnLogin()){
            //frmLogin.getTxtCorreo().setText("");
            //frmLogin.getTxtContrasena().setText("");
            
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

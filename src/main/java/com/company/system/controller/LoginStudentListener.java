
package com.company.system.controller;

import com.company.system.service.UserService;
import com.company.system.view.InitialWindow;
import com.company.system.view.LoginStudent;
import com.company.system.view.RegisterStudent;
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
public class LoginStudentListener implements ActionListener, MouseListener, KeyListener{
    private final LoginStudent frmLogin;
    private RegisterStudent frmRegisterStudent;
    private final UserService userService;
    
    
    public LoginStudentListener(LoginStudent frmLogin){
        this.frmLogin = frmLogin;
        this.userService = new UserService();
        addListeners();
    }
    
    private void addListeners(){
        frmLogin.getBtnLogin().addActionListener(this);
        frmLogin.getBtnLogin().addMouseListener(this);
        frmLogin.getBtnLogin().addKeyListener(this);
        frmLogin.getBtnBack().addActionListener(this);
        frmLogin.getBtnBack().addMouseListener(this);
        frmLogin.getBtnRegister().addActionListener(this);
        frmLogin.getBtnRegister().addMouseListener(this);
    }
    
    private void verifyLogin() {
        try {
            Long idUser = Long.valueOf(frmLogin.getTxtIdCard().getText());
            if (userService.librarianExists(idUser)) {
                String plainPassword = "";
                for (char p : frmLogin.getPswUser().getPassword()) {
                    plainPassword += p;
                }

                if (userService.login(idUser, plainPassword) != null) {
                    frmLogin.login();
                } else {
                    frmLogin.errorMessage(frmLogin.errorIncorrectPassword);
                }
            } else {
                frmLogin.errorMessage(frmLogin.errorUserExists);
            }
        } catch (NumberFormatException ex) {
            frmLogin.errorMessage(frmLogin.errorFormatId);
        }
    }
    private void verifyFields() {
        if (!frmLogin.getTxtIdCard().getText().equals("")
                && frmLogin.getPswUser().getPassword().length != 0) {
            verifyLogin();
        } else {
            frmLogin.errorMessage(frmLogin.errorEmptyFields);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.back();
        }else if (e.getSource() == frmLogin.getBtnLogin()){
            verifyFields();
        }else if (e.getSource() == frmLogin.getBtnRegister()){
            frmRegisterStudent = new RegisterStudent();
            frmRegisterStudent.setVisible(true);
            new RegisterStudentListener(frmRegisterStudent);
            frmLogin.dispose();
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.mouseEvent(frmLogin.getBtnBack(), Utils.btnEntered);
        } else if (e.getSource() == frmLogin.getBtnLogin()) {
            frmLogin.mouseEvent(frmLogin.getBtnLogin(), Utils.btnEntered);
        } else if (e.getSource() == frmLogin.getBtnRegister()) {
            frmLogin.mouseEvent(frmLogin.getBtnRegister(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == frmLogin.getBtnBack()) {
            frmLogin.mouseEvent(frmLogin.getBtnBack(), Utils.btnExited);
        } else if (e.getSource() == frmLogin.getBtnLogin()) {
            frmLogin.mouseEvent(frmLogin.getBtnLogin(), Utils.btnExited);
        } else if (e.getSource() == frmLogin.getBtnRegister()) {
            frmLogin.mouseEvent(frmLogin.getBtnRegister(), Utils.btnExited);
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            verifyFields();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    
    
}

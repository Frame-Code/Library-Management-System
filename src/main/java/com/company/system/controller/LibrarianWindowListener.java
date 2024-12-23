package com.company.system.controller;

import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.LibrarianWindow;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Joel Pazmiño Abad
 */
public class LibrarianWindowListener implements ActionListener, MouseListener {
    private final LibrarianWindow frmLibraianWindow;
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;
    private final User librarian;

    public LibrarianWindowListener(LibrarianWindow frmLibraianWindow) {
        this.frmLibraianWindow = frmLibraianWindow;
        this.bookService = new BookService();
        this.userService = new UserService();
        this.librarian = userService.getLibrarianByIdCard(941239261L);
        this.loanService = new LoanService();
        addListeners();
    }

    private void addListeners() {
        frmLibraianWindow.getPnlRegisterLoan().addMouseListener(this);
        frmLibraianWindow.getPnlRegisterDevolution().addMouseListener(this);
        frmLibraianWindow.getPnlManageFine().addMouseListener(this);
        frmLibraianWindow.getPnlManageBooks().addMouseListener(this);
        frmLibraianWindow.getPnlGenerateReports().addMouseListener(this);
        frmLibraianWindow.getPnlNotifications().addMouseListener(this);
        frmLibraianWindow.getPnlShutdown().addMouseListener(this);

        frmLibraianWindow.getLblRegisterFine().addMouseListener(this);
        frmLibraianWindow.getLblRegisterDevolution().addMouseListener(this);
        frmLibraianWindow.getLblManageFine().addMouseListener(this);
        frmLibraianWindow.getLblManageBooks().addMouseListener(this);
        frmLibraianWindow.getLblManageReports().addMouseListener(this);
        frmLibraianWindow.getLblNotifications().addMouseListener(this);
        frmLibraianWindow.getLblShutdown().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            frmLibraianWindow.getMenuItems().forEach((item) -> {
                if(e.getSource() == item){
                    frmLibraianWindow.openGenerateReport(item.getText());
                }   
            }); 
        } catch(NullPointerException e1) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraianWindow.getPnlRegisterLoan() || e.getSource() == frmLibraianWindow.getLblRegisterFine()) {
            frmLibraianWindow.openRegisterLoan(librarian, bookService, userService, loanService);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlEntered);
        } else if (e.getSource() == frmLibraianWindow.getPnlManageBooks()|| e.getSource() == frmLibraianWindow.getLblManageBooks()) {
            frmLibraianWindow.openRegisterBook(librarian, bookService, userService, loanService);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlEntered);
        } else if(e.getSource() == frmLibraianWindow.getPnlGenerateReports() || e.getSource() == frmLibraianWindow.getLblManageReports()){
            //frmLibraianWindow.openGenerateReports(librarian, bookService, userService, loanService);
            frmLibraianWindow.uploadListMenuReports();
            frmLibraianWindow.getMenuItems().forEach((item) -> {
                item.addActionListener(this);
            }); 
            frmLibraianWindow.getMenuContextual().show(frmLibraianWindow.getPnlGenerateReports(), e.getX(), e.getY());
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlEntered);
        } else if(e.getSource() == frmLibraianWindow.getPnlShutdown() || e.getSource() == frmLibraianWindow.getLblShutdown()){
            frmLibraianWindow.dispose();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == frmLibraianWindow.getPnlRegisterLoan() || e.getSource() == frmLibraianWindow.getLblRegisterFine()) {
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterLoan().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlRegisterDevolution() || e.getSource() == frmLibraianWindow.getLblRegisterDevolution()) {
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlManageFine() || e.getSource() == frmLibraianWindow.getLblManageFine()) {
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);

            frmLibraianWindow.getPnlManageFine().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlManageBooks() || e.getSource() == frmLibraianWindow.getLblManageBooks()) {
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlGenerateReports() || e.getSource() == frmLibraianWindow.getLblManageReports()) {
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlNotifications() || e.getSource() == frmLibraianWindow.getLblNotifications()) {
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlNotifications().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlShutdown() || e.getSource() == frmLibraianWindow.getLblShutdown()) {
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlNotifications().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().repaint();

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

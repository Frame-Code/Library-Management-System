package com.company.system.controller;

import com.company.system.model.User;
import com.company.system.service.BookService;
import com.company.system.service.FineService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.LibrarianWindow;
import com.company.system.view.RegisterBook;
import com.company.system.view.RegisterFine;
import com.company.system.view.RegisterLoan;
import com.company.system.view.components.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Joel Pazmiño Abad
 */
public class LibrarianWindowListener implements ActionListener, MouseListener {

    private final LibrarianWindow frmLibraianWindow;
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;
    private final FineService fineService;
    private final User librarian;

    private String contenedor;

    public LibrarianWindowListener(LibrarianWindow frmLibraianWindow) {
        this.frmLibraianWindow = frmLibraianWindow;
        this.bookService = new BookService();
        this.userService = new UserService();
        this.librarian = new User();
        this.librarian.setNames("Daniel ");  //ELiminar esto
        this.librarian.setSurNames("Mora Cantillo"); //ELiminar esto
        this.loanService = new LoanService();
        this.fineService = new FineService();
        addListeners();
    }

    private void addListeners() {
        frmLibraianWindow.getPnlRegisterLoan().addMouseListener(this);
        frmLibraianWindow.getPnlRegisterDevolution().addMouseListener(this);
        frmLibraianWindow.getPnlManageFine().addMouseListener(this);
        frmLibraianWindow.getPnlManageBooks().addMouseListener(this);
        frmLibraianWindow.getPnlGenerateReports().addMouseListener(this);
        frmLibraianWindow.getPnlShutdown().addMouseListener(this);

        frmLibraianWindow.getLblRegisterFine().addMouseListener(this);
        frmLibraianWindow.getLblRegisterDevolution().addMouseListener(this);
        frmLibraianWindow.getLblManageFine().addMouseListener(this);
        frmLibraianWindow.getLblManageBooks().addMouseListener(this);
        frmLibraianWindow.getLblManageReports().addMouseListener(this);
        frmLibraianWindow.getLblShutdown().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        if (contenedor.equals(LibrarianWindow.optionManageReports)) {
            frmLibraianWindow.getMenuItems().forEach((item) -> {
                if (e.getSource() == item) {
                    frmLibraianWindow.openGenerateReport(item.getText());
                }
            });
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlEntered);
        } else if (contenedor.equals(LibrarianWindow.optionManageFine)) {
            if (source.getText().equals(RegisterFine.typeRegisterNew)) {
                frmLibraianWindow.openRegisterFine(userService, fineService);

            } else if (source.getText().equals(RegisterFine.typeShowFines)) {
                frmLibraianWindow.openHistoryFines(userService);
            }
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlEntered);

        } else if(contenedor.equals(LibrarianWindow.optionRegisterLoan)) {
            if(source.getText().equals(RegisterLoan.typeRegisterNew)) {
                frmLibraianWindow.openRegisterLoan(librarian, bookService, userService, loanService);
                
            } else if(source.getText().equals(RegisterLoan.typeShowLoans)) {
                frmLibraianWindow.openHistoryLoans(userService, loanService);
            }
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlEntered);
        
        } else if(contenedor.equals(LibrarianWindow.optionManageBooks)) {
            if(source.getText().equals(RegisterBook.typeRegisterNew)) {
                frmLibraianWindow.openRegisterBook(librarian, bookService);
            } else if(source.getText().equals(RegisterBook.typeShowBook)) {
                frmLibraianWindow.openFindBook(bookService);
            }
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlEntered);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmLibraianWindow.getPnlRegisterLoan() || e.getSource() == frmLibraianWindow.getLblRegisterFine()) {
            contenedor = frmLibraianWindow.getLblRegisterFine().getText();
            frmLibraianWindow.uploadListMenuLoans();
            frmLibraianWindow.getMenuItems().forEach(item -> {
                item.addActionListener(this);
            });
            frmLibraianWindow.getMenuContextual().show(frmLibraianWindow.getPnlRegisterLoan(), e.getX(), e.getY());
        } else if (e.getSource() == frmLibraianWindow.getPnlGenerateReports() || e.getSource() == frmLibraianWindow.getLblManageReports()) {
            contenedor = frmLibraianWindow.getLblManageReports().getText();
            frmLibraianWindow.uploadListMenuReports();
            frmLibraianWindow.getMenuItems().forEach((item) -> {
                item.addActionListener(this);
            });
            frmLibraianWindow.getMenuContextual().show(frmLibraianWindow.getPnlGenerateReports(), e.getX(), e.getY());
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlEntered);
        } else if (e.getSource() == frmLibraianWindow.getPnlManageFine() || e.getSource() == frmLibraianWindow.getLblManageFine()) {
            contenedor = frmLibraianWindow.getLblManageFine().getText();
            frmLibraianWindow.uploadListMenuFines();
            frmLibraianWindow.getMenuItems().forEach(item -> {
                item.addActionListener(this);
            });
            frmLibraianWindow.getMenuContextual().show(frmLibraianWindow.getPnlManageFine(), e.getX(), e.getY());
            
        } else if (e.getSource() == frmLibraianWindow.getPnlManageBooks()|| e.getSource() == frmLibraianWindow.getLblManageBooks()) {
            contenedor = frmLibraianWindow.getLblManageBooks().getText();
            frmLibraianWindow.uploadListMenuBooks();
            frmLibraianWindow.getMenuItems().forEach((item) -> {
                item.addActionListener(this);
            });
            frmLibraianWindow.getMenuContextual().show(frmLibraianWindow.getPnlManageBooks(), e.getX(), e.getY());
        } else if (e.getSource() == frmLibraianWindow.getPnlShutdown() || e.getSource() == frmLibraianWindow.getLblShutdown()) {
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
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterLoan().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlRegisterDevolution() || e.getSource() == frmLibraianWindow.getLblRegisterDevolution()) {
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlManageFine() || e.getSource() == frmLibraianWindow.getLblManageFine()) {
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);

            frmLibraianWindow.getPnlManageFine().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlManageBooks() || e.getSource() == frmLibraianWindow.getLblManageBooks()) {
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlGenerateReports() || e.getSource() == frmLibraianWindow.getLblManageReports()) {
            frmLibraianWindow.getPnlGenerateReports().setBackground(Utils.pnlEntered);
            frmLibraianWindow.getPnlRegisterLoan().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlRegisterDevolution().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageFine().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlManageBooks().setBackground(Utils.pnlExited);
            frmLibraianWindow.getPnlGenerateReports().repaint();

        } else if (e.getSource() == frmLibraianWindow.getPnlShutdown() || e.getSource() == frmLibraianWindow.getLblShutdown()) {
            frmLibraianWindow.getPnlShutdown().setBackground(Utils.pnlEntered);
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

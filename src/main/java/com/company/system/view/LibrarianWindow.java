package com.company.system.view;

import com.company.system.controller.LibrarianWindowListener;
import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ariel
 */
public class LibrarianWindow extends javax.swing.JFrame {

    public LibrarianWindow() {
        initComponents();
        setResizable(true);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        contentPane = new BackgroundPanel("src/main/resources/images/Background_login.png");
        pnlBackground = new RoundedPanelWithShadow(30, new Color(0, 0, 0, 100), 2);
        pnlWelcome = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblWelcome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jlabeladm = new javax.swing.JLabel();
        lblBookIcon = new javax.swing.JLabel(new ImageIcon("/src/main/resources/images/Student_icon_Login.png"
        ));
        pnlRegisterLoan = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage = new javax.swing.JLabel();
        lblRegisterFine = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnlManageBooks = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        lblManageBooks = new javax.swing.JLabel();
        jlusersimage1 = new javax.swing.JLabel();
        pnlGenerateReports = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        lblManageReports = new javax.swing.JLabel();
        jlreportimage = new javax.swing.JLabel();
        pnlNotifications = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        lblNotifications = new javax.swing.JLabel();
        jlreportimage2 = new javax.swing.JLabel();
        pnlShutdown = new RoundedPanelWithShadow(25,new Color (0,0,0,100),2);
        lblShutdown = new javax.swing.JLabel();
        jlreportimage3 = new javax.swing.JLabel();
        pnlRegisterDevolution = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage1 = new javax.swing.JLabel();
        lblRegisterDevolution = new javax.swing.JLabel();
        pnlManageFine = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage2 = new javax.swing.JLabel();
        lblManageFine = new javax.swing.JLabel();
        pnlWelcome1 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblWelcome1 = new javax.swing.JLabel();
        pnlPrincipal = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(79, 90, 100));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setForeground(new java.awt.Color(255, 255, 255));

        pnlWelcome.setBackground(new java.awt.Color(56, 75, 147));
        pnlWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("BIENVENIDO");

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("User");

        jlabeladm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LibrarianIconHome.png"))); // NOI18N

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabeladm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome))
                .addGap(128, 128, 128))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3))
                            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblUser)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addComponent(jlabeladm, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );

        pnlRegisterLoan.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegisterLoan.setRequestFocusEnabled(false);

        jlbookimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoanIcon.png"))); // NOI18N

        lblRegisterFine.setBackground(new java.awt.Color(255, 255, 255));
        lblRegisterFine.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblRegisterFine.setForeground(new java.awt.Color(0, 0, 0));
        lblRegisterFine.setText("Registrar préstamo");
        lblRegisterFine.setToolTipText("");
        lblRegisterFine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlRegisterLoanLayout = new javax.swing.GroupLayout(pnlRegisterLoan);
        pnlRegisterLoan.setLayout(pnlRegisterLoanLayout);
        pnlRegisterLoanLayout.setHorizontalGroup(
            pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLoanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegisterFine, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlRegisterLoanLayout.setVerticalGroup(
            pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegisterFine))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(56, 75, 147));
        jSeparator2.setForeground(new java.awt.Color(56, 75, 147));

        pnlManageBooks.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageBooks.setPreferredSize(new java.awt.Dimension(287, 52));

        lblManageBooks.setBackground(new java.awt.Color(255, 255, 255));
        lblManageBooks.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblManageBooks.setForeground(new java.awt.Color(0, 0, 0));
        lblManageBooks.setText("Administrar libros");
        lblManageBooks.setToolTipText("");
        lblManageBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlusersimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manageBookIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlManageBooksLayout = new javax.swing.GroupLayout(pnlManageBooks);
        pnlManageBooks.setLayout(pnlManageBooksLayout);
        pnlManageBooksLayout.setHorizontalGroup(
            pnlManageBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageBooksLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlusersimage1)
                .addGap(18, 18, 18)
                .addComponent(lblManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlManageBooksLayout.setVerticalGroup(
            pnlManageBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageBooksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlusersimage1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
            .addGroup(pnlManageBooksLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblManageBooks)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlGenerateReports.setBackground(new java.awt.Color(255, 255, 255));
        pnlGenerateReports.setPreferredSize(new java.awt.Dimension(287, 52));

        lblManageReports.setBackground(new java.awt.Color(255, 255, 255));
        lblManageReports.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblManageReports.setForeground(new java.awt.Color(0, 0, 0));
        lblManageReports.setText("Generación de reportes");
        lblManageReports.setToolTipText("");
        lblManageReports.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reportIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlGenerateReportsLayout = new javax.swing.GroupLayout(pnlGenerateReports);
        pnlGenerateReports.setLayout(pnlGenerateReportsLayout);
        pnlGenerateReportsLayout.setHorizontalGroup(
            pnlGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerateReportsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlreportimage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblManageReports, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGenerateReportsLayout.setVerticalGroup(
            pnlGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGenerateReportsLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jlreportimage)
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGenerateReportsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblManageReports)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNotifications.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotifications.setPreferredSize(new java.awt.Dimension(287, 52));

        lblNotifications.setBackground(new java.awt.Color(255, 255, 255));
        lblNotifications.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblNotifications.setForeground(new java.awt.Color(0, 0, 0));
        lblNotifications.setText("Notificaciones");
        lblNotifications.setToolTipText("");
        lblNotifications.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notifyIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlNotificationsLayout = new javax.swing.GroupLayout(pnlNotifications);
        pnlNotifications.setLayout(pnlNotificationsLayout);
        pnlNotificationsLayout.setHorizontalGroup(
            pnlNotificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificationsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage2)
                .addGap(18, 18, 18)
                .addComponent(lblNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNotificationsLayout.setVerticalGroup(
            pnlNotificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificationsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlreportimage2)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificationsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblNotifications)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlShutdown.setBackground(new java.awt.Color(255, 255, 255));
        pnlShutdown.setPreferredSize(new java.awt.Dimension(287, 52));

        lblShutdown.setBackground(new java.awt.Color(255, 255, 255));
        lblShutdown.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblShutdown.setForeground(new java.awt.Color(0, 0, 0));
        lblShutdown.setText("Salir");
        lblShutdown.setToolTipText("");
        lblShutdown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shutdownIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlShutdownLayout = new javax.swing.GroupLayout(pnlShutdown);
        pnlShutdown.setLayout(pnlShutdownLayout);
        pnlShutdownLayout.setHorizontalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShutdownLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShutdownLayout.setVerticalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShutdownLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlreportimage3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblShutdown, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        pnlRegisterDevolution.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegisterDevolution.setRequestFocusEnabled(false);

        jlbookimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/devolutionIcon.png"))); // NOI18N

        lblRegisterDevolution.setBackground(new java.awt.Color(255, 255, 255));
        lblRegisterDevolution.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblRegisterDevolution.setForeground(new java.awt.Color(0, 0, 0));
        lblRegisterDevolution.setText("Registrar devolución");
        lblRegisterDevolution.setToolTipText("");
        lblRegisterDevolution.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlRegisterDevolutionLayout = new javax.swing.GroupLayout(pnlRegisterDevolution);
        pnlRegisterDevolution.setLayout(pnlRegisterDevolutionLayout);
        pnlRegisterDevolutionLayout.setHorizontalGroup(
            pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterDevolutionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegisterDevolution, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlRegisterDevolutionLayout.setVerticalGroup(
            pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterDevolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbookimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegisterDevolution))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlManageFine.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageFine.setRequestFocusEnabled(false);

        jlbookimage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fineIcon.png"))); // NOI18N

        lblManageFine.setBackground(new java.awt.Color(255, 255, 255));
        lblManageFine.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblManageFine.setForeground(new java.awt.Color(0, 0, 0));
        lblManageFine.setText("Administrar multas");
        lblManageFine.setToolTipText("");
        lblManageFine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlManageFineLayout = new javax.swing.GroupLayout(pnlManageFine);
        pnlManageFine.setLayout(pnlManageFineLayout);
        pnlManageFineLayout.setHorizontalGroup(
            pnlManageFineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFineLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblManageFine, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlManageFineLayout.setVerticalGroup(
            pnlManageFineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageFineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbookimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManageFine))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlManageBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(pnlGenerateReports, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(pnlNotifications, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(pnlShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlRegisterLoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRegisterDevolution, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlManageFine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblBookIcon)
                    .addContainerGap(268, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRegisterLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlRegisterDevolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlManageFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnlManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlGenerateReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pnlShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(655, Short.MAX_VALUE)))
        );

        pnlWelcome1.setBackground(new java.awt.Color(255, 255, 255));
        pnlWelcome1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblWelcome1.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        lblWelcome1.setForeground(new java.awt.Color(0, 0, 0));
        lblWelcome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome1.setText("Administrar biblioteca");

        javax.swing.GroupLayout pnlWelcome1Layout = new javax.swing.GroupLayout(pnlWelcome1);
        pnlWelcome1.setLayout(pnlWelcome1Layout);
        pnlWelcome1Layout.setHorizontalGroup(
            pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcome1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlWelcome1Layout.setVerticalGroup(
            pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcome1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(pnlWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibrarianWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LibrarianWindow lb = new LibrarianWindow();
                new LibrarianWindowListener(lb);
                lb.setVisible(true);
            }
        });
    }

    public JPanel getPnlGenerateReports() {
        return pnlGenerateReports;
    }

    public JPanel getPnlManageBooks() {
        return pnlManageBooks;
    }

    public JPanel getPnlManageFine() {
        return pnlManageFine;
    }

    public JPanel getPnlNotifications() {
        return pnlNotifications;
    }

    public JPanel getPnlRegisterDevolution() {
        return pnlRegisterDevolution;
    }

    public JPanel getPnlRegisterLoan() {
        return pnlRegisterLoan;
    }

    public JPanel getPnlShutdown() {
        return pnlShutdown;
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public JLabel getLblManageBooks() {
        return lblManageBooks;
    }

    public JLabel getLblManageFine() {
        return lblManageFine;
    }

    public JLabel getLblManageReports() {
        return lblManageReports;
    }

    public JLabel getLblNotifications() {
        return lblNotifications;
    }

    public JLabel getLblRegisterDevolution() {
        return lblRegisterDevolution;
    }

    public JLabel getLblRegisterFine() {
        return lblRegisterFine;
    }

    public JLabel getLblShutdown() {
        return lblShutdown;
    }
    
    

    public void uploadPanel(JPanel panel) {
        pnlPrincipal.removeAll();
        pnlPrincipal.add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
    }

    public void changeColorPanel(Color color, Component component) {
        if (component instanceof JPanel) {
            ((JPanel) component).setBackground(color);
        } else if (component instanceof JLabel) {
            ((JLabel) component).setOpaque(true);
            ((JLabel) component).setBackground(color);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlabeladm;
    private javax.swing.JLabel jlbookimage;
    private javax.swing.JLabel jlbookimage1;
    private javax.swing.JLabel jlbookimage2;
    private javax.swing.JLabel jlreportimage;
    private javax.swing.JLabel jlreportimage2;
    private javax.swing.JLabel jlreportimage3;
    private javax.swing.JLabel jlusersimage1;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblManageBooks;
    private javax.swing.JLabel lblManageFine;
    private javax.swing.JLabel lblManageReports;
    private javax.swing.JLabel lblNotifications;
    private javax.swing.JLabel lblRegisterDevolution;
    private javax.swing.JLabel lblRegisterFine;
    private javax.swing.JLabel lblShutdown;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlGenerateReports;
    private javax.swing.JPanel pnlManageBooks;
    private javax.swing.JPanel pnlManageFine;
    private javax.swing.JPanel pnlNotifications;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlRegisterDevolution;
    private javax.swing.JPanel pnlRegisterLoan;
    private javax.swing.JPanel pnlShutdown;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcome1;
    // End of variables declaration//GEN-END:variables
}
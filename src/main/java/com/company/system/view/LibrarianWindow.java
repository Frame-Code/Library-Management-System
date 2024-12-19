package com.company.system.view;

import com.company.system.view.components.BackgroundPanel;
import com.company.system.view.components.RoundedPanelWithShadow;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author ariel
 */
public class LibrarianWindow extends javax.swing.JFrame {

    public LibrarianWindow() {
        initComponents();
        setResizable(true);
        setSize(1080,720);
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
        lblbook = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnlManageBooks = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook2 = new javax.swing.JLabel();
        jlusersimage1 = new javax.swing.JLabel();
        pnlGenerateReports = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook3 = new javax.swing.JLabel();
        jlreportimage = new javax.swing.JLabel();
        pnlNotification = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook5 = new javax.swing.JLabel();
        jlreportimage2 = new javax.swing.JLabel();
        pnlShutdown = new RoundedPanelWithShadow(25,new Color (0,0,0,100),2);
        lblbook6 = new javax.swing.JLabel();
        jlreportimage3 = new javax.swing.JLabel();
        pnlRegisterDevolution = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage1 = new javax.swing.JLabel();
        lblbook4 = new javax.swing.JLabel();
        pnlManageFines = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage2 = new javax.swing.JLabel();
        lblbook7 = new javax.swing.JLabel();
        pnlWelcome1 = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 2);
        lblWelcome1 = new javax.swing.JLabel();

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

        lblbook.setBackground(new java.awt.Color(255, 255, 255));
        lblbook.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook.setForeground(new java.awt.Color(0, 0, 0));
        lblbook.setText("Registrar préstamo");
        lblbook.setToolTipText("");
        lblbook.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlRegisterLoanLayout = new javax.swing.GroupLayout(pnlRegisterLoan);
        pnlRegisterLoan.setLayout(pnlRegisterLoanLayout);
        pnlRegisterLoanLayout.setHorizontalGroup(
            pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLoanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlRegisterLoanLayout.setVerticalGroup(
            pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblbook, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(56, 75, 147));
        jSeparator2.setForeground(new java.awt.Color(56, 75, 147));

        pnlManageBooks.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageBooks.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook2.setBackground(new java.awt.Color(255, 255, 255));
        lblbook2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook2.setForeground(new java.awt.Color(0, 0, 0));
        lblbook2.setText("Administrar libros");
        lblbook2.setToolTipText("");
        lblbook2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlusersimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manageBookIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlManageBooksLayout = new javax.swing.GroupLayout(pnlManageBooks);
        pnlManageBooks.setLayout(pnlManageBooksLayout);
        pnlManageBooksLayout.setHorizontalGroup(
            pnlManageBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageBooksLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlusersimage1)
                .addGap(18, 18, 18)
                .addComponent(lblbook2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlManageBooksLayout.setVerticalGroup(
            pnlManageBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageBooksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlManageBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlusersimage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlManageBooksLayout.createSequentialGroup()
                        .addComponent(lblbook2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))))
        );

        pnlGenerateReports.setBackground(new java.awt.Color(255, 255, 255));
        pnlGenerateReports.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook3.setBackground(new java.awt.Color(255, 255, 255));
        lblbook3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook3.setForeground(new java.awt.Color(0, 0, 0));
        lblbook3.setText("Generación de reportes");
        lblbook3.setToolTipText("");
        lblbook3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reportIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlGenerateReportsLayout = new javax.swing.GroupLayout(pnlGenerateReports);
        pnlGenerateReports.setLayout(pnlGenerateReportsLayout);
        pnlGenerateReportsLayout.setHorizontalGroup(
            pnlGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerateReportsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlreportimage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGenerateReportsLayout.setVerticalGroup(
            pnlGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGenerateReportsLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(pnlGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlreportimage)
                    .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pnlNotification.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotification.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook5.setBackground(new java.awt.Color(255, 255, 255));
        lblbook5.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook5.setForeground(new java.awt.Color(0, 0, 0));
        lblbook5.setText("Notificaciones");
        lblbook5.setToolTipText("");
        lblbook5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notifyIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlNotificationLayout = new javax.swing.GroupLayout(pnlNotification);
        pnlNotification.setLayout(pnlNotificationLayout);
        pnlNotificationLayout.setHorizontalGroup(
            pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificationLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage2)
                .addGap(18, 18, 18)
                .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNotificationLayout.setVerticalGroup(
            pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificationLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlreportimage2))
                .addGap(11, 11, 11))
        );

        pnlShutdown.setBackground(new java.awt.Color(255, 255, 255));
        pnlShutdown.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook6.setBackground(new java.awt.Color(255, 255, 255));
        lblbook6.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook6.setForeground(new java.awt.Color(0, 0, 0));
        lblbook6.setText("Salir");
        lblbook6.setToolTipText("");
        lblbook6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shutdownIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlShutdownLayout = new javax.swing.GroupLayout(pnlShutdown);
        pnlShutdown.setLayout(pnlShutdownLayout);
        pnlShutdownLayout.setHorizontalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShutdownLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShutdownLayout.setVerticalGroup(
            pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShutdownLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(pnlShutdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlreportimage3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        pnlRegisterDevolution.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegisterDevolution.setRequestFocusEnabled(false);

        jlbookimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/devolutionIcon.png"))); // NOI18N

        lblbook4.setBackground(new java.awt.Color(255, 255, 255));
        lblbook4.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook4.setForeground(new java.awt.Color(0, 0, 0));
        lblbook4.setText("Registrar devolución");
        lblbook4.setToolTipText("");
        lblbook4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlRegisterDevolutionLayout = new javax.swing.GroupLayout(pnlRegisterDevolution);
        pnlRegisterDevolution.setLayout(pnlRegisterDevolutionLayout);
        pnlRegisterDevolutionLayout.setHorizontalGroup(
            pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterDevolutionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegisterDevolutionLayout.setVerticalGroup(
            pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterDevolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegisterDevolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblbook4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbookimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlManageFines.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageFines.setRequestFocusEnabled(false);

        jlbookimage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fineIcon.png"))); // NOI18N

        lblbook7.setBackground(new java.awt.Color(255, 255, 255));
        lblbook7.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook7.setForeground(new java.awt.Color(0, 0, 0));
        lblbook7.setText("Administrar multas");
        lblbook7.setToolTipText("");
        lblbook7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlManageFinesLayout = new javax.swing.GroupLayout(pnlManageFines);
        pnlManageFines.setLayout(pnlManageFinesLayout);
        pnlManageFinesLayout.setHorizontalGroup(
            pnlManageFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFinesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlManageFinesLayout.setVerticalGroup(
            pnlManageFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFinesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageFinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbookimage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(pnlNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(pnlShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlRegisterLoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRegisterDevolution, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlManageFines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlManageFines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnlManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlGenerateReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pnlShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(748, Short.MAX_VALUE)))
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
                .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlWelcome1Layout.setVerticalGroup(
            pnlWelcome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcome1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(pnlWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(744, 744, 744))
                    .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                new LibrarianWindow().setVisible(true);
            }
        });
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
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JLabel lblbook;
    private javax.swing.JLabel lblbook2;
    private javax.swing.JLabel lblbook3;
    private javax.swing.JLabel lblbook4;
    private javax.swing.JLabel lblbook5;
    private javax.swing.JLabel lblbook6;
    private javax.swing.JLabel lblbook7;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlGenerateReports;
    private javax.swing.JPanel pnlManageBooks;
    private javax.swing.JPanel pnlManageFines;
    private javax.swing.JPanel pnlNotification;
    private javax.swing.JPanel pnlRegisterDevolution;
    private javax.swing.JPanel pnlRegisterLoan;
    private javax.swing.JPanel pnlShutdown;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcome1;
    // End of variables declaration//GEN-END:variables
}

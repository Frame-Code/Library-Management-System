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
        pnlCategory = new RoundedPanelWithShadow(25, new Color(0, 0, 0, 100), 0);
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelBook = new RoundedPanelWithShadow(25,new Color (0,0,0,0),0);
        jlbookimage = new javax.swing.JLabel();
        lblbook = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelBook1 = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook1 = new javax.swing.JLabel();
        jlusersimage = new javax.swing.JLabel();
        jPanelBook2 = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook2 = new javax.swing.JLabel();
        jlusersimage1 = new javax.swing.JLabel();
        jPanelBook3 = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook3 = new javax.swing.JLabel();
        jlreportimage = new javax.swing.JLabel();
        jPanelBook5 = new RoundedPanelWithShadow(0,new Color (0,0,0,0),0);
        lblbook5 = new javax.swing.JLabel();
        jlreportimage2 = new javax.swing.JLabel();
        jPanelBook6 = new RoundedPanelWithShadow(25,new Color (0,0,0,100),2);
        lblbook6 = new javax.swing.JLabel();
        jlreportimage3 = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
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

        jlabeladm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LibrarianIconHome.png"))); // NOI18N

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

        pnlCategory.setBackground(new java.awt.Color(255, 255, 255));
        pnlCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlCategoryLayout = new javax.swing.GroupLayout(pnlCategory);
        pnlCategory.setLayout(pnlCategoryLayout);
        pnlCategoryLayout.setHorizontalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel4)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        pnlCategoryLayout.setVerticalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jPanelBook.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook.setRequestFocusEnabled(false);

        jlbookimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fdsf(4)(2)(2).png"))); // NOI18N

        lblbook.setBackground(new java.awt.Color(255, 255, 255));
        lblbook.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook.setForeground(new java.awt.Color(0, 0, 0));
        lblbook.setText("Registrar devolución");
        lblbook.setToolTipText("");
        lblbook.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelBookLayout = new javax.swing.GroupLayout(jPanelBook);
        jPanelBook.setLayout(jPanelBookLayout);
        jPanelBookLayout.setHorizontalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelBookLayout.setVerticalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblbook, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(56, 75, 147));
        jSeparator2.setForeground(new java.awt.Color(56, 75, 147));

        jPanelBook1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook1.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook1.setBackground(new java.awt.Color(255, 255, 255));
        lblbook1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook1.setForeground(new java.awt.Color(0, 0, 0));
        lblbook1.setText("Administrar estudiantes");
        lblbook1.setToolTipText("");
        lblbook1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlusersimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/209914-200(1).png"))); // NOI18N

        javax.swing.GroupLayout jPanelBook1Layout = new javax.swing.GroupLayout(jPanelBook1);
        jPanelBook1.setLayout(jPanelBook1Layout);
        jPanelBook1Layout.setHorizontalGroup(
            jPanelBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlusersimage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBook1Layout.setVerticalGroup(
            jPanelBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBook1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlusersimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbook1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelBook2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook2.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook2.setBackground(new java.awt.Color(255, 255, 255));
        lblbook2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook2.setForeground(new java.awt.Color(0, 0, 0));
        lblbook2.setText("Administrar libros");
        lblbook2.setToolTipText("");
        lblbook2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlusersimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PngItem_194508(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanelBook2Layout = new javax.swing.GroupLayout(jPanelBook2);
        jPanelBook2.setLayout(jPanelBook2Layout);
        jPanelBook2Layout.setHorizontalGroup(
            jPanelBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlusersimage1)
                .addGap(18, 18, 18)
                .addComponent(lblbook2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBook2Layout.setVerticalGroup(
            jPanelBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlusersimage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBook2Layout.createSequentialGroup()
                        .addComponent(lblbook2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanelBook3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook3.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook3.setBackground(new java.awt.Color(255, 255, 255));
        lblbook3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook3.setForeground(new java.awt.Color(0, 0, 0));
        lblbook3.setText("Generación de reportes");
        lblbook3.setToolTipText("");
        lblbook3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pngwing.com(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanelBook3Layout = new javax.swing.GroupLayout(jPanelBook3);
        jPanelBook3.setLayout(jPanelBook3Layout);
        jPanelBook3Layout.setHorizontalGroup(
            jPanelBook3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlreportimage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBook3Layout.setVerticalGroup(
            jPanelBook3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBook3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanelBook3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlreportimage)
                    .addComponent(lblbook3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanelBook5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook5.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook5.setBackground(new java.awt.Color(255, 255, 255));
        lblbook5.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook5.setForeground(new java.awt.Color(0, 0, 0));
        lblbook5.setText("Notificaciones");
        lblbook5.setToolTipText("");
        lblbook5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notifyIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBook5Layout = new javax.swing.GroupLayout(jPanelBook5);
        jPanelBook5.setLayout(jPanelBook5Layout);
        jPanelBook5Layout.setHorizontalGroup(
            jPanelBook5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage2)
                .addGap(18, 18, 18)
                .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBook5Layout.setVerticalGroup(
            jPanelBook5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBook5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelBook5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlreportimage2))
                .addGap(11, 11, 11))
        );

        jPanelBook6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBook6.setPreferredSize(new java.awt.Dimension(287, 52));

        lblbook6.setBackground(new java.awt.Color(255, 255, 255));
        lblbook6.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        lblbook6.setForeground(new java.awt.Color(0, 0, 0));
        lblbook6.setText("Salir");
        lblbook6.setToolTipText("");
        lblbook6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlreportimage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shutdownIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBook6Layout = new javax.swing.GroupLayout(jPanelBook6);
        jPanelBook6.setLayout(jPanelBook6Layout);
        jPanelBook6Layout.setHorizontalGroup(
            jPanelBook6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBook6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlreportimage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBook6Layout.setVerticalGroup(
            jPanelBook6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBook6Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanelBook6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbook6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlreportimage3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelBook2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jPanelBook1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jPanelBook3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jPanelBook5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jPanelBook6, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(pnlCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanelBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lblBookIcon)
                    .addContainerGap(537, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanelBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelBook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pnlCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanelBook2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanelBook3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanelBook5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(jPanelBook6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBookIcon)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setOpaque(false);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktopPane))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(pnlWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desktopPane))
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
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanelBook;
    private javax.swing.JPanel jPanelBook1;
    private javax.swing.JPanel jPanelBook2;
    private javax.swing.JPanel jPanelBook3;
    private javax.swing.JPanel jPanelBook5;
    private javax.swing.JPanel jPanelBook6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlabeladm;
    private javax.swing.JLabel jlbookimage;
    private javax.swing.JLabel jlreportimage;
    private javax.swing.JLabel jlreportimage2;
    private javax.swing.JLabel jlreportimage3;
    private javax.swing.JLabel jlusersimage;
    private javax.swing.JLabel jlusersimage1;
    private javax.swing.JLabel lblBookIcon;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JLabel lblbook;
    private javax.swing.JLabel lblbook1;
    private javax.swing.JLabel lblbook2;
    private javax.swing.JLabel lblbook3;
    private javax.swing.JLabel lblbook5;
    private javax.swing.JLabel lblbook6;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcome1;
    // End of variables declaration//GEN-END:variables
}

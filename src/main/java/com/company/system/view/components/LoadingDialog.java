package com.company.system.view.components;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 * 
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoadingDialog extends JFrame{
    private JLabel loadingLabel;

    public LoadingDialog(String titleDialog, String titleLabel) {
        super(titleDialog);
        setLayout(new BorderLayout());
        setSize(300, 100);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(300,100);
        addComponents(titleLabel);
    }

    private void addComponents(String titleLabel) {
        loadingLabel = new JLabel(titleLabel, JLabel.CENTER);
        add(loadingLabel, BorderLayout.CENTER);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        add(progressBar, BorderLayout.SOUTH);
    }
}

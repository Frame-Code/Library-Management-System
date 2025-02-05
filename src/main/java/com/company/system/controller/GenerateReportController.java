package com.company.system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.company.system.model.User;
import com.company.system.service.ReportService;
import com.company.system.service.UserService;
import com.company.system.view.FileChooser;
import com.company.system.view.GenerateReport;
import com.company.system.view.components.Utils;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author artisti-code (Daniel Mora Cantillo)
 */
public class GenerateReportController implements ActionListener, MouseListener {

    private final GenerateReport generateReport;
    private final ReportService reportService;
    private final UserService userService;

    private User student;

    public GenerateReportController(GenerateReport generateReport) {
        this.generateReport = generateReport;
        this.reportService = new ReportService();
        this.userService = new UserService();
        addListeners();
    }

    private void addListeners() {
        generateReport.getBtnDowloadReport().addActionListener(this);
        generateReport.getBtnSearch().addActionListener(this);
        generateReport.getBtnDowloadReport().addMouseListener(this);
        generateReport.getBtnSearch().addMouseListener(this);

    }

    private void verifyAndGenerateReport(String option, int limit, String filePath) throws DocumentException, IOException {
        if (option.equals(GenerateReport.typeLatestBooksBorrowed)) {
            reportService.generateLastLoansReport(limit, filePath, generateReport.getLibrarian());
        } else if (option.equals(GenerateReport.typeMostBorrowedBooks)) {
            reportService.generateMostBorrowedBooksReport(limit, filePath, generateReport.getLibrarian());
        } else if (option.equals(GenerateReport.typeLoanHistoryByStudent)) {
            if (student != null) {
                reportService.generateLoanHistoryByStudentReport(student, filePath, generateReport.getLibrarian());
            } else {
                generateReport.showMessage("Primero busca un estudiante", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateReport.getBtnDowloadReport()) {
            try {
                int limit = Integer.parseInt(generateReport.getTxtLimit().getText());
                String filePath = new FileChooser().filePath();
                generateReport.showLoadingDialog();

                Thread generate = new Thread(() -> {
                    try {
                        Thread.sleep(500);
                        verifyAndGenerateReport(generateReport.getOptionSelected(), limit, filePath);

                        SwingUtilities.invokeLater(() -> {
                            generateReport.hideLoadingDialog();
                            generateReport.showMessage("Reporte creado correctamente ", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        });
                    } catch (DocumentException | IOException | InterruptedException ex) {
                        generateReport.hideLoadingDialog();
                        generateReport.showMessage("Error al crear el reporte", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    } 
                });
                
                generate.start();
                
            } catch (NumberFormatException ex) {
                generateReport.showMessage("Escribe correctamente la cantidad de resultados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == generateReport.getBtnSearch()) {
            try {
                Long idCard = Long.valueOf(generateReport.getTxtIdCardUser().getText());
                student = userService.getStudentByIdCard(idCard);
                generateReport.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());
                generateReport.showMessage("Estudiante encontrado!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                generateReport.showMessage("Escribe correctamente el numero de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == generateReport.getBtnSearch()) {
            generateReport.paintButton(generateReport.getBtnSearch(), Utils.btnEntered);
            generateReport.paintButton(generateReport.getBtnDowloadReport(), Utils.btnExited);
        } else if (e.getSource() == generateReport.getBtnDowloadReport()) {
            generateReport.paintButton(generateReport.getBtnSearch(), Utils.btnExited);
            generateReport.paintButton(generateReport.getBtnDowloadReport(), Utils.btnEntered);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == generateReport.getBtnSearch()) {
            generateReport.paintButton(generateReport.getBtnSearch(), Utils.btnExited);
        } else if (e.getSource() == generateReport.getBtnDowloadReport()) {
            generateReport.paintButton(generateReport.getBtnDowloadReport(), Utils.btnExited);
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

}

package com.company.system.controller;

import com.company.system.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.company.system.service.PDFReportGenerator;
import com.company.system.service.ReportService;
import com.company.system.service.UserService;
import com.company.system.view.FileChooser;
import com.company.system.view.GenerateReport;
import com.company.system.view.components.Utils;
import com.itextpdf.text.DocumentException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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

    private void verifyOption(String option, int limit) throws DocumentException, IOException {
        String filePath = new FileChooser().filePath();
        if (option.equals(GenerateReport.typeLatestBooksBorrowed)) {
            PDFReportGenerator.generateLastLoansReport(reportService.getRecentLoans(limit), filePath, generateReport.getLibrarian());
            generateReport.showMessage("Reporte creado correctamente ", "Exito", JOptionPane.INFORMATION_MESSAGE);
            generateReport.cleanFields();
        } else if (option.equals(GenerateReport.typeMostBorrowedBooks)) {
            System.out.println("Most borrowed");
            generateReport.showMessage("Reporte creado correctamente ", "Exito", JOptionPane.INFORMATION_MESSAGE);
            generateReport.cleanFields();
        } else if (option.equals(GenerateReport.typeLoanHistoryByStudent)) {
            if (student != null) {
                System.out.println("Loan history");
                generateReport.showMessage("Reporte creado correctamente ", "Exito", JOptionPane.INFORMATION_MESSAGE);
                generateReport.cleanFields();
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
                verifyOption(generateReport.getOptionSelected(), limit);
            } catch (NumberFormatException ex) {
                generateReport.showMessage("Escribe correctamente la cantidad de resultados", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DocumentException | IOException ex) {
                generateReport.showMessage("Error de sistema", "Error", JOptionPane.ERROR_MESSAGE);
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

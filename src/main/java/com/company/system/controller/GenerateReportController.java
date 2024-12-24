package com.company.system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.company.system.service.PDFReportGenerator;
import com.company.system.service.ReportService;
import com.company.system.view.FileChooser;
import com.company.system.view.GenerateReport;

/**
 *
 * @author artisti-code (Daniel Mora Cantillo)
 */
public class GenerateReportController implements ActionListener {

    private final GenerateReport generateReport;
    private final ReportService reportService;

    public GenerateReportController(GenerateReport generateReport) {
        this.generateReport = generateReport;
        this.reportService = new ReportService();
        addListeners();
    }

    private void addListeners() {
        generateReport.getBtnDowloadReport().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateReport.getBtnDowloadReport()) {
            try {
                int limit = Integer.parseInt(generateReport.getTxtLimit().getText());

                String filePath = new FileChooser().filePath();
                System.out.println(filePath);
                PDFReportGenerator.generateLastLoansReport(reportService.getRecentLoans(limit), filePath, generateReport.getUser());
                generateReport.showMessage("Reporte creado correctamente ", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                generateReport.showMessage("Escribe correctamente la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(GenerateReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

}

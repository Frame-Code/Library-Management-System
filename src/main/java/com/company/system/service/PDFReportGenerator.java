package com.company.system.service;

import com.company.system.model.Loan;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class PDFReportGenerator {
    public static void generateLastLoansReport(List<Loan> loans, String filePath) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        
        document.open();
        document.add(new Paragraph("Reporte de los ultimos libros prestados"));
        document.add(new Paragraph(" "));
        
        PdfPTable table = new PdfPTable(6); //numero de columnas
        table.addCell("ID Préstamo");
        table.addCell("Usuario");
        table.addCell("Título del libro");
        table.addCell("ISBN");
        table.addCell("Fecha de prestamo");
        table.addCell("¿Ha sido regresado?");
        
        for(Loan loan : loans) {
            table.addCell(String.valueOf(loan.getIdLoan()));
            table.addCell(loan.getUser().getNames() + " " + loan.getUser().getSurNames());
            table.addCell(loan.getBook().getTitle());
            table.addCell(loan.getBook().getIsbn());
            table.addCell(loan.getRegistrationDate().toString());
            table.addCell((loan.isReturned()) ? "Si" : "No");
        }
        document.add(table);
        document.close();
    }
}

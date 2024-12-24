package com.company.system.service;

import com.company.system.model.Loan;
import com.company.system.model.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class PDFReportGenerator {
    public static void generateLastLoansReport(List<Loan> loans, String filePath, User user) throws DocumentException, MalformedURLException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        Image image = Image.getInstance("src/main/resources/images/book_illustration.png");
        image.scaleToFit(80, 80);
        document.open();

        PdfPTable header = new PdfPTable(1);
        PdfPCell cellHeader = new PdfPCell(image);
        cellHeader.setBorder(PdfPCell.NO_BORDER);
        cellHeader.setVerticalAlignment(Element.ALIGN_RIGHT);
        header.addCell(cellHeader);

        cellHeader = new PdfPCell(new Phrase("Sistema de administración de biblioteca", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)));
        cellHeader.setBorder(PdfPCell.NO_BORDER);
        cellHeader.setVerticalAlignment(Element.ALIGN_JUSTIFIED_ALL);

        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.addCell(cellHeader);

        document.add(header);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Fecha: " + LocalDate.now().toString()));
        document.add(new Paragraph("Solicitado por: " + user.getNames() + " " + user.getSurNames()));
        document.add(new Paragraph(" "));

        Paragraph head = new Paragraph("Reporte de los ultimos libros prestados", new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD));
        head.setAlignment(Element.ALIGN_CENTER);
        document.add(head);
        document.add(new Paragraph(" "));

        PdfContentByte cb = writer.getDirectContentUnder();
        cb.moveTo(50, 700);
        cb.lineTo(550, 700);
        cb.stroke();

        PdfPTable table = new PdfPTable(6); //numero de columnas
        String[] headers = {"ID Préstamo", "Usuario", "Título del libro", "ISBN", "Fecha de prestamo", "¿Ha sido regresado?"};  
        for(String headerTable : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(headerTable, new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
            cell.setBackgroundColor(BaseColor.CYAN);
            cell.setPadding(5f);
            table.addCell(headerTable);
        }   
        
        for(Loan loan : loans) {
            PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(loan.getIdLoan())));
            cell.setPadding(5f);
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getUser().getNames() + " " + loan.getUser().getSurNames()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getBook().getTitle()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getBook().getIsbn()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getRegistrationDate().toString()));
            table.addCell(cell);

            cell.setPhrase(new Phrase((loan.isReturned()) ? "Si" : "No"));
            table.addCell(cell);
        }
        document.add(table);
        document.close();
    }
}

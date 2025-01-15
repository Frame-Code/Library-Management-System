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

    private static void addHeader(Document document, String librarianNames)
            throws DocumentException, MalformedURLException, IOException {
        Image image = Image.getInstance("src/main/resources/images/book_illustration.png");
        image.scaleToFit(80, 80);

        // Crea una tabla con una sola columna para agregar la imagen y el titulo
        PdfPTable header = new PdfPTable(1);
        PdfPCell cellHeader = new PdfPCell(image);
        cellHeader.setBorder(PdfPCell.NO_BORDER);
        cellHeader.setVerticalAlignment(Element.ALIGN_RIGHT);
        header.addCell(cellHeader);

        cellHeader = new PdfPCell(new Phrase("Sistema de administración de biblioteca",
                new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)));
        cellHeader.setBorder(PdfPCell.NO_BORDER);
        cellHeader.setVerticalAlignment(Element.ALIGN_JUSTIFIED_ALL);

        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.addCell(cellHeader);

        document.open();
        document.add(header);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Fecha: " + LocalDate.now().toString()));
        document.add(new Paragraph("Solicitado por: " + librarianNames));
        document.add(new Paragraph(" "));
    }

    public static boolean generateLastLoansReport(List<Loan> loans, String filePath, String namesLibrarian) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            addHeader(document, namesLibrarian);

            Paragraph head = new Paragraph("Reporte de los ultimos libros prestados",
                    new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD));
            head.setAlignment(Element.ALIGN_CENTER);
            document.add(head);
            document.add(new Paragraph(" "));

            // Dibujar una linea
            PdfContentByte cb = writer.getDirectContentUnder();
            cb.moveTo(50, 700);
            cb.lineTo(550, 700);
            cb.stroke();

            // Crea una tabla junto con sus columnas
            PdfPTable table = new PdfPTable(6); // numero de columnas
            String[] headers = {"ID Préstamo", "Usuario", "Título del libro", "ISBN", "Fecha de prestamo",
                "¿Ha sido regresado?"};
            for (String headerTable : headers) {
                PdfPCell cell = new PdfPCell(
                        new Phrase(headerTable, new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setPadding(5f);
                table.addCell(cell);
            }

            // Agrega filas a la tabla con los datos de los prestamos
            loans.forEach(loan -> {
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
            });

            document.add(table);
            document.close();
            return true;

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean generateMostBorrowedBooksReport(List<Object[]> loans, String filePath, String namesLibrarian) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            addHeader(document, namesLibrarian);

            Paragraph head = new Paragraph("Reporte de los libros mas prestados",
                    new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD));
            head.setAlignment(Element.ALIGN_CENTER);
            document.add(head);
            document.add(new Paragraph(" "));

            // Dibuja una linea
            PdfContentByte cb = writer.getDirectContentUnder();
            cb.moveTo(50, 700);
            cb.lineTo(550, 700);
            cb.stroke();

            // Crea una tabla junto con sus columnas
            PdfPTable table = new PdfPTable(3); // numero de columnas
            String[] headers = {"ISBN", "Título del libro", "Cantidad de prestamos"};
            for (String headerTable : headers) {
                PdfPCell cell = new PdfPCell(
                        new Phrase(headerTable, new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setPadding(5f);
                table.addCell(cell);
            }

            // Agrega filas a la tabla con los datos de los prestamos
            loans.forEach(loan -> {
                PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(loan[1]))); // Titulo del libro
                cell.setPadding(5f);
                table.addCell(cell);

                cell.setPhrase(new Phrase(String.valueOf(loan[0])));// Isbn
                table.addCell(cell);

                cell.setPhrase(new Phrase(String.valueOf(loan[2])));// Total de prestamos
                table.addCell(cell);
            });
            document.add(table);
            document.close();
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public static boolean generateLoanHistoryByStudent(List<Loan> loans, String filePath, String namesLibrarian, String namesStudent) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        addHeader(document, namesLibrarian);

        Paragraph head = new Paragraph("Historial de prestamos del estudiante " + namesStudent, new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD));
        head.setAlignment(Element.ALIGN_CENTER);
        document.add(head);
        document.add(new Paragraph(" "));

        // Dibuja una linea
        PdfContentByte cb = writer.getDirectContentUnder();
        cb.moveTo(50, 700);
        cb.lineTo(550, 700);
        cb.stroke();

        // Crea una tabla junto con sus columnas
        PdfPTable table = new PdfPTable(6); // numero de columnas
        String[] headers = {"Título del libro", "ISBN", "Fecha de prestamo", "Fecha de devolución",
            "¿Ha sido regresado?", "¿Ha solicitado prorroga?"};
        for (String headerTable : headers) {
            PdfPCell cell = new PdfPCell(
                    new Phrase(headerTable, new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPadding(5f);
            table.addCell(cell);
        }

        // Agrega filas a la tabla con los datos de los prestamos
        loans.forEach(loan -> {
            PdfPCell cell = new PdfPCell(new Phrase(loan.getBook().getTitle()));
            cell.setPadding(5f);
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getBook().getIsbn()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getRegistrationDate().toString()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(loan.getDevolutionDate().toString()));
            table.addCell(cell);

            cell.setPhrase(new Phrase((loan.isReturned()) ? "Si" : "No"));
            table.addCell(cell);

            cell.setPhrase(new Phrase((loan.getRegistrationUpdateDate() != null) ? "Si" : "No"));
            table.addCell(cell);
        });

        document.add(table);
        document.close();
        return true;

    }

}

package com.company.system.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.User;
import com.itextpdf.text.DocumentException;

public class PDFReportGeneratorTest {
    LoanDao loanDao;
    PDFReportGenerator pdfReportGenerator;

    @BeforeEach
    void setUp() {
        loanDao = new LoanDaoImpl();
        pdfReportGenerator = new PDFReportGenerator();
    }

    @Test
    void testGenerateLastLoansReport() throws MalformedURLException, DocumentException, IOException {
        User user = new User();
        user.setNames("Daniel Mora Cantillo");
        PDFReportGenerator.generateLastLoansReport(loanDao.findAllIncludeDeleted(), "/home/artist-code/Documents/last_loans_report.pdf", user);
    }

    @Test
    void testGenerateMostBorrowedBooksReport() throws MalformedURLException, DocumentException, IOException {
        User user = new User();
        user.setNames("Daniel Mora Cantillo");
        PDFReportGenerator.generateMostBorrowedBooksReport(loanDao.findMostBorrowedBooks(5), "/home/artist-code/Documents/most_report.pdf", user);
    }
}

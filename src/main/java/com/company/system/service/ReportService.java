package com.company.system.service;

import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Loan;
import com.company.system.model.User;
import com.itextpdf.text.DocumentException;
import java.io.IOException;

import java.util.List;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class ReportService {
    private final LoanDao loanDao;

    public ReportService() {
        this.loanDao = new LoanDaoImpl();
    }
    
    public List<Loan> getRecentLoans(int limit) {
        return loanDao.findRecentLoans(limit);
    }

    public List<Object[]> getMostBorrowedBooks(int limit) {
        return loanDao.findMostBorrowedBooks(limit);
    }

    public List<Loan> getLoanHistoryByStudent(User student) {
        return loanDao.findByUser(student);
    }

    public boolean generateLastLoansReport(int limit, String filePath, User librarian) {
        String namesLibrarian = librarian.getNames() + " " + librarian.getSurNames();
        return PDFReportGenerator.generateLastLoansReport(getRecentLoans(limit), filePath, namesLibrarian);
    }

    public boolean generateMostBorrowedBooksReport(int limit, String filePath, User librarian) {
        String namesLibrarian = librarian.getNames() + " " + librarian.getSurNames();
        return PDFReportGenerator.generateMostBorrowedBooksReport(getMostBorrowedBooks(limit), filePath, namesLibrarian);
    }

    public boolean generateLoanHistoryByStudentReport(User student, String filePath, User librarian) throws DocumentException, IOException {
        String namesStudent = student.getNames() + " " + student.getSurNames();
        String namesLibrarian = librarian.getNames() + " " + librarian.getSurNames();
        return PDFReportGenerator.generateLoanHistoryByStudent(getLoanHistoryByStudent(student), filePath, namesLibrarian, namesStudent);
    }

}

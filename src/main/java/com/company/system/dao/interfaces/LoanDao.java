package com.company.system.dao.interfaces;

import com.company.system.model.Book;
import java.util.List;

import com.company.system.model.Loan;
import com.company.system.model.User;

public interface LoanDao extends Dao<Loan> {
    List<Loan> findByUser(User user);
    
    List<Loan> findRecentLoans(int limit);
    
    Loan findLoanForDevolution(User student, Book book);
    
    List<Object[]> findMostBorrowedBooks(int limit);
}

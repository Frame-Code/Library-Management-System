package com.company.system.service;

import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.model.Loan;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanServiceTest {
    LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
    }

    @Test
    void testGetLoansByUser() {
        List<Loan> loans = loanService.getLoansByUser(new UserDaoImpl().findById(6L));
        loans.forEach(loan -> {
            System.out.println(loan);
        });
                
    }   

    @Test
    void testRequestExtension() {
        
        System.out.println(loanService.requestExtension(new UserDaoImpl().findById(6L), 
                LocalDate.of(2025, 1, 22)));
    }
}

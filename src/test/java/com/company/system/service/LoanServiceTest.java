package com.company.system.service;

import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.model.Loan;
import java.time.LocalDate;
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
    void testIsEntitledToRequestExtension() {
        //System.out.println(loanService.isEntitledToRequestExtension(new UserDaoImpl().findById(6L)));
    }

    @Test
    void testCheckFinesToRequestExtension() {
        //System.out.println(loanService.checkFinesToRequestExtension(new UserDaoImpl().findById(9L)));
    }

    @Test
    void testRequestExtension() {
       // System.out.println(loanService.requestExtension(new UserDaoImpl().findById(6L),
          //      LocalDate.of(2025, 1, 22)));
    }
}

package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Loan;

public class LoanDaoImplTest {
    private LoanDao loanDao;

    @BeforeEach
    void setUp() {
        this.loanDao = new LoanDaoImpl();
    }

    @Test
    void testCreate() {
        Loan loan = new Loan(new UserDaoImpl().findByIdCard(9412392679L), 
        new BookDaoImpl().findById(4L), LocalDate.now(), "Admin",
         null, null, false);
        System.out.println(loanDao.create(loan));
    }

    @Test
    void testFindByUser() {
        List<Loan> loans = loanDao.findByUser(new UserDaoImpl().findByIdCard(941239292L));
        loans.forEach(loan -> {
            System.out.println(loan);
        });
    }
}

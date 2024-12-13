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
       // System.out.println(loanDao.create(loan));
    }

    @Test
    void testFindByUser() {
        List<Loan> loans = loanDao.findByUser(new UserDaoImpl().findByIdCard(941239292L));
        loans.forEach(loan -> {
            System.out.println(loan);
        });
    }

    @Test
    void testDeleteByID() {
        System.out.println(loanDao.deleteByID(1L));
    }

    @Test
    void testFindAll() {
        List<Loan> loans = loanDao.findAll();
        loans.forEach(loan -> {
            System.out.println(loan);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Loan> loans = loanDao.findAllIncludeDeleted();
        loans.forEach(loan -> {
            System.out.println(loan);
        });
    }

    @Test
    void testFindById() {
        Loan loan = loanDao.findById(1L);
        Loan loan1 = loanDao.findById(2L);
        System.out.println(loan);
        System.out.println(loan1);
    }

    @Test
    void testFindByIdIncludeDeleted() {
        Loan loan = loanDao.findByIdIncludeDeleted(1L);
        System.out.println(loan);
    }

    @Test
    void testUpdate() {
        Loan loan = loanDao.findByIdIncludeDeleted(1L)   ;
        loan.setDeleted(false);
        System.out.println(loanDao.update(loan));
    }
}

package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Loan;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoanDaoImplTest {
    private LoanDao loanDao;

    @BeforeEach
    void setUp() {
        this.loanDao = new LoanDaoImpl();
    }

    @Test
    void testCreate() {
        Loan loan = new Loan(new UserDaoImpl().findById(6L), 
        new BookDaoImpl().findById(13L), LocalDate.of(2024, 11, 15), true,
        LocalDate.of(2024, 11, 15), "Admin",
         null, null, false);

        //System.out.println(loanDao.create(loan));
        
        /*
        Loan loan1 = new Loan(new UserDaoImpl().findById(6L), 
        new BookDaoImpl().findById(3L), LocalDate.of(2024, 12, 15), true,
        LocalDate.of(2024, 12, 15), "Admin",
         null, null, false);

        Loan loan2 = new Loan(new UserDaoImpl().findById(23L), 
        new BookDaoImpl().findById(9L), LocalDate.of(2024, 11, 15), true,
        LocalDate.of(2024, 11, 15), "Admin",
         null, null, false);

        */

        
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
        Loan loan = loanDao.findByIdIncludeDeleted(3L);
        loan.setDevolutionDate(LocalDate.of(2024, 12, 25));
        System.out.println(loanDao.update(loan));
    }

    @Test
    void testFindMostBorrowedBooks() {
        List<Object[]> loans = loanDao.findMostBorrowedBooks(5);
        loans.forEach(loan -> {
            System.out.println(loan[0] + " - " + loan[1] + " - " + loan[2]);
        }); 
    }
}

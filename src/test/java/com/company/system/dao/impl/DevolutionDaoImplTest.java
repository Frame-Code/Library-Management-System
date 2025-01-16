package com.company.system.dao.impl;

import com.company.system.dao.interfaces.BookDao;
import com.company.system.dao.interfaces.DevolutionDao;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Book;
import com.company.system.model.Devolution;
import com.company.system.model.Loan;
import com.company.system.model.User;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class DevolutionDaoImplTest {
    DevolutionDao devolutionDao;
    UserDao userDao;
    BookDao bookDao;
    LoanDao loanDao;
    
    @BeforeEach
    void setUp() {
        this.devolutionDao = new DevolutionDaoImpl();
        this.userDao = new UserDaoImpl();
        this.bookDao = new BookDaoImpl();
        this.loanDao = new LoanDaoImpl();
    }
    
    @Test
    void testCreate() {
       /* User student = userDao.findByIdCard(9412392L);
        Book book = bookDao.findByISBN("JPKL-5");
        Loan loan = loanDao.findById(14L);
        Devolution devolution = new Devolution(student, book, loan, LocalDate.now(), 
                "Admin", null, null, false);
        loan.setReturned(true);
        loan.setDevolution(devolution);
        loanDao.update(loan);*/
        
    }
    
}

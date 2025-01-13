package com.company.system.service;

import com.company.system.dao.impl.BookDaoImpl;
import java.util.List;

import com.company.system.dao.impl.DevolutionDaoImpl;
import com.company.system.dao.impl.FineDaoImpl;
import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.interfaces.BookDao;
import com.company.system.dao.interfaces.DevolutionDao;
import com.company.system.dao.interfaces.FineDao;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Book;
import com.company.system.model.Devolution;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.model.User;
import java.time.LocalDate;

/**
 *
 * @author  artist-code Daniel Mora Cantillo
 */
public class DevolutionService {
    private final DevolutionDao devolutionDao;
    private final LoanDao loanDao; 
    private final BookDao bookDao;
    private final FineDao fineDao;
    

    public DevolutionService() {
        this.devolutionDao = new DevolutionDaoImpl();
        this.loanDao = new LoanDaoImpl();
        this.bookDao = new BookDaoImpl();
        this.fineDao = new FineDaoImpl();
    }

    public List<Devolution> getDevolutionsByStudent(User student) {
        return devolutionDao.findByStudent(student);
    }

    public boolean registerDevolution(Loan loan, User librarian) {
        Devolution devolution = new Devolution(loan.getUser(), loan.getBook(), loan, 
                LocalDate.now(), librarian.getFullNames() + " CI: " + String.valueOf(librarian.getIdCardUser()), 
                null, null, true);
        devolutionDao.create(devolution);
        loan.setDevolution(devolution);
        loan.setReturned(true);
        Book book = loan.getBook();
        book.setStockToLoan(book.getStockToLoan()+1);
        bookDao.update(book);
        
        if(loan.getDevolutionDate().isAfter(LocalDate.now())) {
            Fine fine = new Fine(loan.getUser(), (LocalDate.now().plusDays(15)), "Multa por devolucion tardia", 
                    LocalDate.now(), librarian.getFullNames() + " ci: " + String.valueOf(librarian.getIdCardUser()), 
                    null, null, false);
            fineDao.create(fine);
        }
        
        return loanDao.update(loan);
    }
    

}

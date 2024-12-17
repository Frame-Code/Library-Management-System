package com.company.system.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.company.system.dao.impl.FineDaoImpl;
import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.dao.interfaces.FineDao;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.model.User;

public class LoanService {
    private final LoanDao loanDao;
    private final UserDao userDao;
    private final FineDao fineDao;

    public LoanService() {
        this.loanDao = new LoanDaoImpl();
        this.userDao = new UserDaoImpl();
        this.fineDao = new FineDaoImpl();
    }

    public List<Loan> getLoansByUser(Long idCardUser) {
        return loanDao.findByUser(userDao.findByIdCard(idCardUser));
    }

    public boolean requestExtension(Long idCardUser, LocalDate newDevolutionDate) {
        User user = userDao.findByIdCard(idCardUser);

        Loan lastLoan = new LinkedList<>(getLoansByUser(idCardUser)).getLast();
        LinkedList<Fine> fines = new LinkedList<>(fineDao.findByUser(user));

        if(lastLoan.isReturned() == false &&
        LocalDate.now().isBefore(lastLoan.getDevolutionDate()) &&
        lastLoan.getRegistrationUpdateDate() != null &&
        fines.size() <= 3 &&
        fines.getLast().getDeadline().isBefore(LocalDate.now())) {
            lastLoan.setDevolutionDate(newDevolutionDate);    
            return loanDao.update(lastLoan);
        } else {
            return false;
        }

    }


}

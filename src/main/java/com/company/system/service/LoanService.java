package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Loan;

public class LoanService {
    private final LoanDao loanDao;
    private final UserDao userDao;

    public LoanService() {
        this.loanDao = new LoanDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    public List<Loan> getLoansByUser(Long idCardUser) {
        return loanDao.findByUser(userDao.findByIdCard(idCardUser));
    }
    

}

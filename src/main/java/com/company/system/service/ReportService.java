package com.company.system.service;

import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Loan;
import java.util.List;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class ReportService {
    private final LoanDao loanDao;

    public ReportService() {
        this.loanDao = new LoanDaoImpl();
    }
    
    public List<Loan> getRecentLoans(int limit) {
        return loanDao.findRecentLoans(limit);
    }

}

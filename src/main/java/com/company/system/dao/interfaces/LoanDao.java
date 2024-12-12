package com.company.system.dao.interfaces;

import java.util.List;

import com.company.system.model.Loan;
import com.company.system.model.User;

public interface LoanDao extends Dao<Loan> {
    List<Loan> findByUser(User user);
}

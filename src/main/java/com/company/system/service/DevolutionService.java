package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.DevolutionDaoImpl;
import com.company.system.dao.interfaces.DevolutionDao;
import com.company.system.model.Devolution;
import com.company.system.model.Loan;
import com.company.system.model.User;

/**
 *
 * @author  artist-code Daniel Mora Cantillo
 */
public class DevolutionService {
    private final DevolutionDao devolutionDao;

    public DevolutionService() {
        this.devolutionDao = new DevolutionDaoImpl();
    }

    public List<Devolution> getDevolutionsByStudent(User student) {
        return devolutionDao.findByStudent(student);
    }

    

}

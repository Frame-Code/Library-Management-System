package com.company.system.service;

import com.company.system.dao.impl.FineDaoImpl;
import com.company.system.dao.interfaces.FineDao;
import com.company.system.model.Fine;
import com.company.system.model.User;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class FineService {
    private final FineDao fineDao;

    public FineService() {
        this.fineDao = new FineDaoImpl();
    }
    
    public boolean register(User student, LocalDate deadline, String message, String nameLibrarian) {
        Fine fine = new Fine(student, deadline, message, LocalDate.now(), 
                nameLibrarian, null, null, false);
        
        return fineDao.create(fine);
    }
    
    public List<Fine> getFinesByStudent(User student) {
        return fineDao.findByUser(student);
    }
    
    public boolean updateFine(Long idFine, LocalDate deadline, String message) {
        Fine fine = fineDao.findById(idFine);
        fine.setDeadline(deadline);
        fine.setMessage(message);
        return fineDao.update(fine);
    }
    
}

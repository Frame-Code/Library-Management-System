package com.company.system.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.company.system.dao.impl.FineDaoImpl;
import com.company.system.dao.impl.LoanDaoImpl;
import com.company.system.dao.interfaces.FineDao;
import com.company.system.dao.interfaces.LoanDao;
import com.company.system.model.Book;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class LoanService {

    private final LoanDao loanDao;
    private final FineDao fineDao;
    private final BookService bookService;

    public LoanService() {
        this.loanDao = new LoanDaoImpl();
        this.fineDao = new FineDaoImpl();
        this.bookService = new BookService();
    }
    
    public Loan getLoanById(Long id) {
        return loanDao.findById(id);
    }
    
    public List<Loan> getLoansByUser(User user) {
        return loanDao.findByUser(user);
    }
    
    public boolean deleteLoan(Long idLoan) {
        return loanDao.deleteByID(idLoan);
    }
    
    // Verifica si el usuario tiene multas y si son menos de 3 y si la última multa ya ha pasado la fecha límite
    public boolean checkFinesToRequestExtension(User user) {
        LinkedList<Fine> fines = new LinkedList<>(fineDao.findByUser(user));
        
        if (fines.isEmpty()) {
            return true; // No hay multas, se puede solicitar la prórroga
        } else {
            return fines.size() < 3 && fines.getLast().getDeadline().isBefore(LocalDate.now());
        }
    }

    // Verifica que el usuario tiene préstamos hechos y que el último no ha sido devuelto
    public boolean isEntitledToRequestExtension(User user) {
        LinkedList<Loan> loans = new LinkedList<>(getLoansByUser(user));
        return !loans.isEmpty() && !loans.getLast().isReturned();
    }

    // Verifica si ya se ha solicitado una prórroga para el último préstamo
    public boolean hasAlreadyRequestedExtension(User user) {
        LinkedList<Loan> loans = new LinkedList<>(getLoansByUser(user));
        Loan lastLoan = loans.getLast();
        return lastLoan.getRegistrationUpdateDate() != null; // Si ya tiene una fecha de actualización, ya solicitó una prórroga
    }

    // Verifica que haya un libro pendiente de devolución para poder solicitar la prórroga
    public boolean hasPendingBookForExtension(User user) {
        LinkedList<Loan> loans = new LinkedList<>(getLoansByUser(user));
        return !loans.isEmpty() && !loans.getLast().isReturned();
    }

    // Método para solicitar la prórroga
    public boolean requestExtension(User user, LocalDate newDevolutionDate) {
        // Verificar si hay un préstamo pendiente
        if (!hasPendingBookForExtension(user)) {
            return false; // No hay libros pendientes de devolución
        }

        // Verificar si el usuario tiene multas y si cumple con las condiciones
        if (!checkFinesToRequestExtension(user)) {
            return false; // El usuario tiene más de 3 multas o la última multa no ha pasado la fecha límite
        }

        // Verificar si el usuario ya solicitó una prórroga
        if (hasAlreadyRequestedExtension(user)) {
            return false; // Ya se ha solicitado una prórroga anteriormente
        }

        // Obtener el último préstamo
        Loan lastLoan = new LinkedList<>(getLoansByUser(user)).getLast();

        // Verificar que la fecha actual no sobrepasa la fecha de devolución registrada
        if (LocalDate.now().isAfter(lastLoan.getDevolutionDate())) {
            return false; // La fecha de solicitud no puede ser posterior a la fecha de devolución registrada
        }

        // Si todas las condiciones son válidas, actualizar la fecha de devolución
        lastLoan.setDevolutionDate(newDevolutionDate);
        lastLoan.setRegistrationUpdateDate(LocalDate.now());
        lastLoan.setRegistrationUpdateName(user.getNames() + " " + user.getSurNames() + ", role: " + user.getRole().getName());

        return loanDao.update(lastLoan); // Actualizar la base de datos con la nueva fecha de devolución
    }
    
    public boolean createLoan(User user, Book book, LocalDate devolutionDate, String registrationName) {
        /* Primero es necesario realizar la siguiente verificación:
        1. Que se verifique si el estudiante tiene un prestamo que no ha devulto 
        
        Nota: esta funcion da por sentado que la verificion ya fue hecha
        */
        
        Loan loan = new Loan(user, book, devolutionDate, false, LocalDate.now(), registrationName,
               null, null, false);
        bookService.updateBookStock(book);
        return loanDao.create(loan);
    }

}

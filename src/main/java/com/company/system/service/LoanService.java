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

    public List<Loan> getLoansByUser(User user) {
        return loanDao.findByUser(user);
    }
    
    //Este metodo verifica que el usuario si tiene multas, estas sean menores que 4 y su fecha de finalizacion haya pasado
    public boolean checkFinesToRequestExtension(User user) {
        LinkedList<Fine> fines = new LinkedList<>(fineDao.findByUser(user));
        
        if(fines.isEmpty()) {
            return true;
        } else {
            return fines.size() <= 3 && fines.getLast().getDeadline().isBefore(LocalDate.now());
        }
    }
    
    //Este metodo verifica que el usuario tiene prestamos hechos y si el ultimo prestamo hecho aun no ha sido devuelto
    public boolean isEntitledToRequestExtension(User user) {
        LinkedList<Loan> loans = new LinkedList<>(getLoansByUser(user));
        return !loans.isEmpty() && !loans.getLast().isReturned();
    }

    public boolean requestExtension(User user, LocalDate newDevolutionDate) {
        /* Primero es necesario realizar estas verificaciones:
        1. Que el usuario tiene prestamos hechos y ademas que el ultimo no se haya devuelto (isEntitledToRequestExtension)
            deshabilitando el boton "Solicitar Prorroga" en caso que no sea asi
        
        2. Que si el usuario tiene multas que estas sean menores que 4 y que la ultima multa ya haya pasado (checkFinesToRequestExtension)
            mostrando un mensaje por pantalla que le informe esto al usuario
            
        
        Nota: esta funcion da por sentado que ambas verificiones fueron hechas
        */
        
        Loan lastLoan = new LinkedList<>(getLoansByUser(user)).getLast();

        if (LocalDate.now().isBefore(lastLoan.getDevolutionDate()) && lastLoan.getRegistrationUpdateDate() == null ) {
            lastLoan.setDevolutionDate(newDevolutionDate);
            lastLoan.setRegistrationUpdateDate(LocalDate.now());
            lastLoan.setRegistrationUpdateName(user.getNames() + " " + user.getSurNames() + ", role: " + user.getRole().getName());
            return loanDao.update(lastLoan);
        } else {
            return false;
        }

    }
    
    public boolean createLoan(User user, Book book, LocalDate devolutionDate, String registrationName) {
        /* Primero es necesario realizar la siguiente verificación:
        1. Que se verifique si el estudiante tiene un prestamo que no ha devulto 
        
        Nota: esta funcion da por sentado que la verificion ya fue hecha
        */
        
        Loan loan = new Loan(user, book, devolutionDate, false, LocalDate.now(), registrationName,
               null, null, false);
        book.setStockToLoan(book.getStockToLoan() - 1);
        return loanDao.create(loan);
    }

}

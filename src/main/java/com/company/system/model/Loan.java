package com.company.system.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Loans")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoan")
    private Long idLoan; // Identificador único del préstamo (clave primaria)

    @ManyToOne
    @JoinColumn(name = "fkUser")
    private User user; // Usuario que realiza el préstamo

    @ManyToOne
    @JoinColumn(name = "fkBook")
    private Book book; // Libro que se ha prestado
    
    @Column(nullable = false, name = "devolutionDate")
    private LocalDate devolutionDate; // Fecha límite para devolver el libro. No puede ser nula

    @Column(nullable = false, name = "isReturned")
    private boolean returned; // Indicador de si el libro ha sido devuelto. No puede ser nulo
    
    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha en que el préstamo fue registrado. No puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró el préstamo. No puede ser nulo
    
    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización del préstamo. Puede ser nula
    
    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización. Puede ser nulo
    
    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si el préstamo ha sido eliminado. No puede ser nulo

    // Constructor vacío
    public Loan() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Loan(Long idLoan, User user, Book book, LocalDate devolutionDate, boolean returned,
            LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate,
            String registrationUpdateName, boolean deleted) {
        this.idLoan = idLoan;
        this.user = user;
        this.book = book;
        this.devolutionDate = devolutionDate;
        this.returned = returned;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Constructor sin idLoan, útil para nuevas instancias
    public Loan(User user, Book book, LocalDate devolutionDate, boolean returned, LocalDate registrationDate,
            String registrationName, LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.user = user;
        this.book = book;
        this.devolutionDate = devolutionDate;
        this.returned = returned;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getIdLoan() {
        return idLoan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public LocalDate getRegistrationUpdateDate() {
        return registrationUpdateDate;
    }

    public void setRegistrationUpdateDate(LocalDate registrationUpdateDate) {
        this.registrationUpdateDate = registrationUpdateDate;
    }

    public String getRegistrationUpdateName() {
        return registrationUpdateName;
    }

    public void setRegistrationUpdateName(String registrationUpdateName) {
        this.registrationUpdateName = registrationUpdateName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // Métodos hashCode y equals para comparación de objetos
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLoan == null) ? 0 : idLoan.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((devolutionDate == null) ? 0 : devolutionDate.hashCode());
        result = prime * result + (returned ? 1231 : 1237);
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
        result = prime * result + ((registrationName == null) ? 0 : registrationName.hashCode());
        result = prime * result + ((registrationUpdateDate == null) ? 0 : registrationUpdateDate.hashCode());
        result = prime * result + ((registrationUpdateName == null) ? 0 : registrationUpdateName.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        return result;
    }

    // Método equals para comparar dos objetos Loan
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Loan other = (Loan) obj;
        if (idLoan == null) {
            if (other.idLoan != null)
                return false;
        } else if (!idLoan.equals(other.idLoan))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (devolutionDate == null) {
            if (other.devolutionDate != null)
                return false;
        } else if (!devolutionDate.equals(other.devolutionDate))
            return false;
        if (returned != other.returned)
            return false;
        if (registrationDate == null) {
            if (other.registrationDate != null)
                return false;
        } else if (!registrationDate.equals(other.registrationDate))
            return false;
        if (registrationName == null) {
            if (other.registrationName != null)
                return false;
        } else if (!registrationName.equals(other.registrationName))
            return false;
        if (registrationUpdateDate == null) {
            if (other.registrationUpdateDate != null)
                return false;
        } else if (!registrationUpdateDate.equals(other.registrationUpdateDate))
            return false;
        if (registrationUpdateName == null) {
            if (other.registrationUpdateName != null)
                return false;
        } else if (!registrationUpdateName.equals(other.registrationUpdateName))
            return false;
        if (deleted != other.deleted)
            return false;
        return true;
    }

    // Método toString para representar el préstamo como cadena
    @Override
    public String toString() {
        return "Loan [idLoan=" + idLoan + ", user=" + user + ", book=" + book + ", devolutionDate=" + devolutionDate
                + ", returned=" + returned + ", registrationDate=" + registrationDate + ", registrationName=" 
                + registrationName + ", registrationUpdateDate=" + registrationUpdateDate + ", registrationUpdateName=" 
                + registrationUpdateName + ", deleted=" + deleted + "]";
    }
    
}


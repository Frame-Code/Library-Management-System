package com.company.system.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    private Book book;
    
    @OneToOne
    @JoinColumn(name = "fkDevolution")
    private Devolution devolution;
    
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
        this.devolution = null;
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

    public Devolution getDevolution() {
        return devolution;
    }

    public void setDevolution(Devolution devolution) {
        this.devolution = devolution;
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
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idLoan);
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + Objects.hashCode(this.book);
        hash = 67 * hash + Objects.hashCode(this.devolution);
        hash = 67 * hash + Objects.hashCode(this.devolutionDate);
        hash = 67 * hash + (this.returned ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.registrationDate);
        hash = 67 * hash + Objects.hashCode(this.registrationName);
        hash = 67 * hash + Objects.hashCode(this.registrationUpdateDate);
        hash = 67 * hash + Objects.hashCode(this.registrationUpdateName);
        hash = 67 * hash + (this.deleted ? 1 : 0);
        return hash;
    }

    // Método equals para comparar dos objetos Loan
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (this.returned != other.returned) {
            return false;
        }
        if (this.deleted != other.deleted) {
            return false;
        }
        if (!Objects.equals(this.registrationName, other.registrationName)) {
            return false;
        }
        if (!Objects.equals(this.registrationUpdateName, other.registrationUpdateName)) {
            return false;
        }
        if (!Objects.equals(this.idLoan, other.idLoan)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.devolution, other.devolution)) {
            return false;
        }
        if (!Objects.equals(this.devolutionDate, other.devolutionDate)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(this.registrationUpdateDate, other.registrationUpdateDate);
    }

    // Método toString para representar el préstamo como cadena
    @Override
    public String toString() {
        return "Loan{" + "idLoan=" + idLoan + ", user=" + user + ", book=" + book + ", devolution=" + devolution + ", devolutionDate=" + devolutionDate + ", returned=" + returned + ", registrationDate=" + registrationDate + ", registrationName=" + registrationName + ", registrationUpdateDate=" + registrationUpdateDate + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted + '}';
    }
    
}


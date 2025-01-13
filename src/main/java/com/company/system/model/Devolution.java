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
@Table(name = "Devolutions")
public class Devolution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDevolution")
    private Long idDovolution; // Identificador único de la devolución (clave primaria)

    @ManyToOne
    @JoinColumn(name = "fkUser")
    private User user; // Usuario que realizó la devolución

    @ManyToOne
    @JoinColumn(name = "fkBook")
    private Book book; // Libro que fue devuelto

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha de registro de la devolución. No puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró la devolución. No puede ser nulo

    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización. Puede ser nula

    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización. Puede ser nulo

    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si la devolución ha sido eliminada. No puede ser nulo

    // Constructor vacío
    public Devolution() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Devolution(Long idDovolution, User user, Book book, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.idDovolution = idDovolution;
        this.user = user;
        this.book = book;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Constructor sin el idDovolution (en caso de no contar con él al crear una nueva devolución)
    public Devolution(User user, Book book, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.user = user;
        this.book = book;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getIdDovolution() {
        return idDovolution;
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
        result = prime * result + ((idDovolution == null) ? 0 : idDovolution.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
        result = prime * result + ((registrationName == null) ? 0 : registrationName.hashCode());
        result = prime * result + ((registrationUpdateDate == null) ? 0 : registrationUpdateDate.hashCode());
        result = prime * result + ((registrationUpdateName == null) ? 0 : registrationUpdateName.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        return result;
    }

    // Método equals para comparar dos objetos Devolution
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Devolution other = (Devolution) obj;
        if (idDovolution == null) {
            if (other.idDovolution != null)
                return false;
        } else if (!idDovolution.equals(other.idDovolution))
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

    // Método toString para representar la devolución como cadena
    @Override
    public String toString() {
        return "Devolution [idDovolution=" + idDovolution + ", user=" + user + ", book=" + book + ", registrationDate="
                + registrationDate + ", registrationName=" + registrationName + ", registrationUpdateDate="
                + registrationUpdateDate + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted
                + "]";
    }


}


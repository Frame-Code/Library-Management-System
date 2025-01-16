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
import javax.persistence.Table;

@Entity
@Table(name = "Fines")
public class Fine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFine")
    private Long idFine; // Identificador único de la multa (clave primaria)

    @ManyToOne
    @JoinColumn(name = "fkUser", nullable = false)
    private User user; // Usuario al que se le aplica la multa

    @Column(nullable = false, name = "deadline")
    private LocalDate deadline; // Fecha límite para pagar la multa. No puede ser nula

    @Column(nullable = false, name = "message")
    private String message; // Mensaje asociado a la multa (razón o descripción). No puede ser nulo

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha en que la multa fue registrada. No puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró la multa. No puede ser nulo

    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización de la multa. Puede ser nula

    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización. Puede ser nulo

    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si la multa ha sido eliminada. No puede ser nulo

    // Constructor vacío
    public Fine() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Fine(User user, LocalDate deadline, String message, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.user = user;
        this.deadline = deadline;
        this.message = message;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getIdFine() {
        return idFine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        hash = 67 * hash + Objects.hashCode(this.idFine);
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + Objects.hashCode(this.deadline);
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.registrationDate);
        hash = 67 * hash + Objects.hashCode(this.registrationName);
        hash = 67 * hash + Objects.hashCode(this.registrationUpdateDate);
        hash = 67 * hash + Objects.hashCode(this.registrationUpdateName);
        hash = 67 * hash + (this.deleted ? 1 : 0);
        return hash;
    }

    // Método equals para comparar dos objetos Fine
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
        final Fine other = (Fine) obj;
        if (this.deleted != other.deleted) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.registrationName, other.registrationName)) {
            return false;
        }
        if (!Objects.equals(this.registrationUpdateName, other.registrationUpdateName)) {
            return false;
        }
        if (!Objects.equals(this.idFine, other.idFine)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(this.registrationUpdateDate, other.registrationUpdateDate);
    }

    // Método toString para representar la multa como cadena
    @Override
    public String toString() {
        return "Fine{" + "idFine=" + idFine + ", user=" + user + ", deadline=" + deadline + ", message=" + message + ", registrationDate=" + registrationDate + ", registrationName=" + registrationName + ", registrationUpdateDate=" + registrationUpdateDate + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted + '}';
    }
    
}


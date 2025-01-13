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

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long idUser; // Identificador único del usuario (clave primaria)

    @Column(unique = true, nullable = false, name = "idCardUser")
    private Long idCardUser; // Número de tarjeta del usuario, debe ser único y no nulo

    @Column(length = 60, nullable = false, name = "names")
    private String names; // Nombres del usuario, no puede ser nulo

    @Column(length = 60, nullable = false, name = "surNames")
    private String surNames; // Apellidos del usuario, no puede ser nulo

    @Column(length = 60, unique = true, nullable = false, name = "email")
    private String email; // Correo electrónico del usuario, debe ser único y no nulo

    @Column(length = 64, nullable = false, name = "passwordHash")
    private String passwordHash; // Contraseña en formato hash, no puede ser nulo

    @Column(name = "bornDate")
    private LocalDate bornDate; // Fecha de nacimiento del usuario (opcional)

    @ManyToOne
    @JoinColumn(name = "fkRole")
    private Role role; // Relación con el rol del usuario

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha en que el usuario fue registrado, no puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró al usuario, no puede ser nulo

    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización (opcional)

    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización (opcional)

    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si el usuario ha sido eliminado. No puede ser nulo

    // Constructor vacío
    public User() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public User(Long idCardUser, String names, String surNames, String email, String passwordHash, LocalDate bornDate, Role role, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.idCardUser = idCardUser;
        this.names = names;
        this.surNames = surNames;
        this.email = email;
        this.passwordHash = passwordHash;
        this.bornDate = bornDate;
        this.role = role;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getIdUser() {
        return idUser;
    }

    public Long getIdCardUser() {
        return idCardUser;
    }

    public void setIdCardUser(Long idCardUser) {
        this.idCardUser = idCardUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurNames() {
        return surNames;
    }

    public void setSurNames(String surNames) {
        this.surNames = surNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        hash = 89 * hash + Objects.hashCode(this.idUser);
        hash = 89 * hash + Objects.hashCode(this.idCardUser);
        hash = 89 * hash + Objects.hashCode(this.names);
        hash = 89 * hash + Objects.hashCode(this.surNames);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.passwordHash);
        hash = 89 * hash + Objects.hashCode(this.bornDate);
        hash = 89 * hash + Objects.hashCode(this.role);
        hash = 89 * hash + Objects.hashCode(this.registrationDate);
        hash = 89 * hash + Objects.hashCode(this.registrationName);
        hash = 89 * hash + Objects.hashCode(this.registrationUpdateDate);
        hash = 89 * hash + Objects.hashCode(this.registrationUpdateName);
        hash = 89 * hash + (this.deleted ? 1 : 0);
        return hash;
    }

    // Método equals para comparar dos objetos User
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
        final User other = (User) obj;
        if (this.deleted != other.deleted) {
            return false;
        }
        if (!Objects.equals(this.names, other.names)) {
            return false;
        }
        if (!Objects.equals(this.surNames, other.surNames)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.passwordHash, other.passwordHash)) {
            return false;
        }
        if (!Objects.equals(this.registrationName, other.registrationName)) {
            return false;
        }
        if (!Objects.equals(this.registrationUpdateName, other.registrationUpdateName)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.idCardUser, other.idCardUser)) {
            return false;
        }
        if (!Objects.equals(this.bornDate, other.bornDate)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(this.registrationUpdateDate, other.registrationUpdateDate);
    }

    // Método toString para representar el usuario como cadena
    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + 
                ", idCardUser=" + idCardUser + 
                ", names=" + names + 
                ", surNames=" + surNames + 
                ", email=" + email + 
                ", passwordHash=" + passwordHash + 
                ", bornDate=" + bornDate + 
                ", role=" + role + 
                ", registrationDate=" + registrationDate + 
                ", registrationName=" + registrationName + 
                ", registrationUpdateDate=" + registrationUpdateDate + 
                ", registrationUpdateName=" + registrationUpdateName + 
                ", deleted=" + deleted + 
                '}';
    }
    
    
    
    
}

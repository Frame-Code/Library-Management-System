package com.company.system.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
@Entity
@Table(name="Roles")
public class Role implements Serializable {

    public static final String roleLibrarian = "Bibliotecario"; // Rol para bibliotecarios
    public static final String roleStudent = "Estudiante"; // Rol para estudiantes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRole")
    private Long id; // Identificador único del rol (clave primaria)

    @Column(unique = true, nullable = false, name = "name")
    private String name; // Nombre del rol, debe ser único y no nulo

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha en que se registró el rol. No puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró el rol. No puede ser nulo
    
    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización del rol. Puede ser nula
    
    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización. Puede ser nulo
    
    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si el rol ha sido eliminado. No puede ser nulo

    // Constructor vacío
    public Role() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Role(String name, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate, 
                String registrationUpdateName, boolean deleted) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.registrationDate);
        hash = 13 * hash + Objects.hashCode(this.registrationName);
        hash = 13 * hash + Objects.hashCode(this.registrationUpdateDate);
        hash = 13 * hash + Objects.hashCode(this.registrationUpdateName);
        hash = 13 * hash + (this.deleted ? 1 : 0);
        return hash;
    }

    // Método equals para comparar dos objetos Role
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
        final Role other = (Role) obj;
        if (this.deleted != other.deleted) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.registrationName, other.registrationName)) {
            return false;
        }
        if (!Objects.equals(this.registrationUpdateName, other.registrationUpdateName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(this.registrationUpdateDate, other.registrationUpdateDate);
    }

    // Método toString para representar el rol como cadena
    @Override
    public String toString() {
        return "Role{" + "id=" + id + 
                ", name=" + name + 
                ", registrationDate=" + registrationDate + 
                ", registrationName=" + registrationName + 
                ", registrationUpdateDate=" + registrationUpdateDate + 
                ", registrationUpdateName=" + registrationUpdateName + 
                ", deleted=" + deleted + '}';
    }
    
    
    
    
}


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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRole")
    private Long id;
    
    @Column(unique = true, nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate;

    @Column(nullable = false, name = "registrationName")
    private String registrationName;
    
    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate;
    
    @Column(name = "registrationUpdateName")
    private String registrationUpdateName;
    
    @Column(name = "idDeleted", nullable = false)
    private boolean deleted;
    
    public Role() {
    }

    public Role(Long id, String name, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Role(String name, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

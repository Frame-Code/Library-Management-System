package com.company.system.model;

import java.time.LocalDate;

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
@Table(name="Publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPublisher")
    private Long idPublisher;

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

    public Publisher() {
    }

    public Publisher(Long idPublisher, String name, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.idPublisher = idPublisher;
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Publisher(String name, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate,
            String registrationUpdateName, boolean deleted) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Long getIdPublisher() {
        return idPublisher;
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPublisher == null) ? 0 : idPublisher.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
        result = prime * result + ((registrationName == null) ? 0 : registrationName.hashCode());
        result = prime * result + ((registrationUpdateDate == null) ? 0 : registrationUpdateDate.hashCode());
        result = prime * result + ((registrationUpdateName == null) ? 0 : registrationUpdateName.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Publisher other = (Publisher) obj;
        if (idPublisher == null) {
            if (other.idPublisher != null)
                return false;
        } else if (!idPublisher.equals(other.idPublisher))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
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

    @Override
    public String toString() {
        return "Publisher [idPublisher=" + idPublisher + ", name=" + name + ", registrationDate=" + registrationDate
                + ", registrationName=" + registrationName + ", registrationUpdateDate=" + registrationUpdateDate
                + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted + "]";
    }
    
}

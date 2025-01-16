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
@Table(name="Categories")
public class Category {
    // Constantes de las categorías disponibles en el sistema
    public static final String categoryHistory = "Historia";
    public static final String categoryScience = "Cientifico";
    public static final String categoryBibliography = "Bibliografia";
    public static final String categoryLinguistic = "Linguistico";
    public static final String categoryCode = "Programación";
    public static final String categoryMedicine = "Medicina";
    public static final String categoryEnginner = "Ingenieria";
    public static final String categoryPychology = "Psicologia";
    public static final String categoryPhisic = "Fisica";
    public static final String categoryMathematics = "Matematicas";
    public static final String categoryBiology = "Biologia";
    public static final String categoryChemistry = "Quimica";
    public static final String categorySociology = "Sociologia";
    public static final String categoryAI = "Inteligencia artifical";
    public static final String categoryElectronic = "Electronica";
    public static final String categoryArchitecture = "Arquitectura";
    public static final String categoryRomance = "Romance";
    public static final String categoryPoetry = "Poesia";
    public static final String categoryHorror = "Terror";
    public static final String categoryFantasy = "Fantasia";
    public static final String categorySciFi = "Ciencia ficcion";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategory")
    private Long idCategory; // Identificador único de la categoría (clave primaria)

    @Column(unique = true, nullable = false, name = "name")
    private String name; // Nombre de la categoría. No puede ser nulo

    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate; // Fecha de registro de la categoría. No puede ser nula

    @Column(nullable = false, name = "registrationName")
    private String registrationName; // Nombre de la persona que registró la categoría. No puede ser nulo
    
    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate; // Fecha de la última actualización. Puede ser nula
    
    @Column(name = "registrationUpdateName")
    private String registrationUpdateName; // Nombre de la persona que realizó la última actualización. Puede ser nulo
    
    @Column(name = "isDeleted", nullable = false)
    private boolean deleted; // Indicador de si la categoría ha sido eliminada. No puede ser nulo

    // Constructor vacío
    public Category() {
    }

    // Constructor con parámetros
    public Category(String name, LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate,
            String registrationUpdateName, boolean deleted) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Métodos getters y setters
    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
        result = prime * result + ((registrationName == null) ? 0 : registrationName.hashCode());
        result = prime * result + ((registrationUpdateDate == null) ? 0 : registrationUpdateDate.hashCode());
        result = prime * result + ((registrationUpdateName == null) ? 0 : registrationUpdateName.hashCode());
        result = prime * result + (deleted ? 1231 : 1237);
        return result;
    }

    // Método equals para comparar dos objetos Category
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (idCategory == null) {
            if (other.idCategory != null)
                return false;
        } else if (!idCategory.equals(other.idCategory))
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

    // Método toString para representar la categoría como cadena
    @Override
    public String toString() {
        return "Category [idCategory=" + idCategory + ", name=" + name + ", registrationDate=" + registrationDate
                + ", registrationName=" + registrationName + ", registrationUpdateDate=" + registrationUpdateDate
                + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted + "]";
    }
}

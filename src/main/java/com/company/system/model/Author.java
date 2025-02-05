package com.company.system.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
@Entity
@Table(name="Authors")
public class Author {
    
    // Identificador único de la entidad Author
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAuthor")
    private Long idAuthor;

    // Nombre del autor, único y no nulo
    @Column(unique = true, nullable = false, name = "names")
    private String names;

    // Apellidos del autor, único y no nulo
    @Column(unique = true, nullable = false, name = "surNames")
    private String surNames;

    // Relación muchos a muchos con la entidad Book (un autor puede tener muchos libros)
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    // Fecha de registro del autor
    @Column(nullable = false, name = "registrationDate")
    private LocalDate registrationDate;

    // Nombre de la persona que registró al autor
    @Column(nullable = false, name = "registrationName")
    private String registrationName;

    // Fecha de última actualización del registro
    @Column(name = "registrationUpdateDate")
    private LocalDate registrationUpdateDate;

    // Nombre de la persona que realizó la última actualización
    @Column(name = "registrationUpdateName")
    private String registrationUpdateName;

    // Marca para indicar si el autor ha sido eliminado (lógico)
    @Column(name = "isDeleted", nullable = false)
    private boolean deleted;

    // Constructor por defecto
    public Author() {
    }

    // Constructor completo que incluye todos los atributos
    public Author(String names, String surNames, List<Book> books, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.names = names;
        this.surNames = surNames;
        this.books = books;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    // Constructor sin la lista de libros
    public Author(String names, String surNames, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.names = names;
        this.surNames = surNames;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }
    
    public String getFullNames() {
        return getNames() + " " + getSurNames();
    }

    // Getters y setters para cada uno de los atributos

    public Long getIdAuthor() {
        return idAuthor;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    // Métodos de comparación (hashCode y equals) para comparar dos autores por sus atributos

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAuthor == null) ? 0 : idAuthor.hashCode());
        result = prime * result + ((names == null) ? 0 : names.hashCode());
        result = prime * result + ((surNames == null) ? 0 : surNames.hashCode());
        result = prime * result + ((books == null) ? 0 : books.hashCode());
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
        Author other = (Author) obj;
        if (idAuthor == null) {
            if (other.idAuthor != null)
                return false;
        } else if (!idAuthor.equals(other.idAuthor))
            return false;
        if (names == null) {
            if (other.names != null)
                return false;
        } else if (!names.equals(other.names))
            return false;
        if (surNames == null) {
            if (other.surNames != null)
                return false;
        } else if (!surNames.equals(other.surNames))
            return false;
        if (books == null) {
            if (other.books != null)
                return false;
        } else if (!books.equals(other.books))
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

    // Método toString para obtener una representación en cadena del objeto Author

    @Override
    public String toString() {
        return "Author [idAuthor=" + idAuthor + ", names=" + names + ", surNames=" + surNames + ", books=" + books
                + ", registrationDate=" + registrationDate + ", registrationName=" + registrationName
                + ", registrationUpdateDate=" + registrationUpdateDate + ", registrationUpdateName="
                + registrationUpdateName + ", deleted=" + deleted + "]";
    }

}
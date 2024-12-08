package com.company.system.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBook")
    private Long idBook;

    @Column(unique = true, nullable = false, name = "isbn")
    private Long isbn;
    
    
    @Column(unique = true, nullable = false, name = "title")
    private String title;
    
    @Column(unique = true, nullable = false, name = "description", length = 255)
    private String description;
    
    @Column(nullable = false, name = "yearPublished")
    private LocalDate yearPublished;
    
    @Column(nullable = false, name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "fkPublisher")
    private Publisher fkPublisher;

    @ManyToMany
    @JoinTable(
        name = "book_author", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "book_id"), // Clave foránea hacia Book
        inverseJoinColumns = @JoinColumn(name = "author_id") // Clave foránea hacia Author
    )
    private List<Author> authors;

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

    public Book() {
    }

    public Book(Long idBook, Long isbn, String title, String description, LocalDate yearPublished, Integer stock,
            Publisher fkPublisher, List<Author> authors, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.yearPublished = yearPublished;
        this.stock = stock;
        this.fkPublisher = fkPublisher;
        this.authors = authors;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Book(Long isbn, String title, String description, LocalDate yearPublished, Integer stock,
            Publisher fkPublisher, List<Author> authors, LocalDate registrationDate, String registrationName,
            LocalDate registrationUpdateDate, String registrationUpdateName, boolean deleted) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.yearPublished = yearPublished;
        this.stock = stock;
        this.fkPublisher = fkPublisher;
        this.authors = authors;
        this.registrationDate = registrationDate;
        this.registrationName = registrationName;
        this.registrationUpdateDate = registrationUpdateDate;
        this.registrationUpdateName = registrationUpdateName;
        this.deleted = deleted;
    }

    public Long getIdBook() {
        return idBook;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(LocalDate yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Publisher getFkPublisher() {
        return fkPublisher;
    }

    public void setFkPublisher(Publisher fkPublisher) {
        this.fkPublisher = fkPublisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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
        result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((yearPublished == null) ? 0 : yearPublished.hashCode());
        result = prime * result + ((stock == null) ? 0 : stock.hashCode());
        result = prime * result + ((fkPublisher == null) ? 0 : fkPublisher.hashCode());
        result = prime * result + ((authors == null) ? 0 : authors.hashCode());
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
        Book other = (Book) obj;
        if (idBook == null) {
            if (other.idBook != null)
                return false;
        } else if (!idBook.equals(other.idBook))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (yearPublished == null) {
            if (other.yearPublished != null)
                return false;
        } else if (!yearPublished.equals(other.yearPublished))
            return false;
        if (stock == null) {
            if (other.stock != null)
                return false;
        } else if (!stock.equals(other.stock))
            return false;
        if (fkPublisher == null) {
            if (other.fkPublisher != null)
                return false;
        } else if (!fkPublisher.equals(other.fkPublisher))
            return false;
        if (authors == null) {
            if (other.authors != null)
                return false;
        } else if (!authors.equals(other.authors))
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
        return "Book [idBook=" + idBook + ", isbn=" + isbn + ", title=" + title + ", description=" + description
                + ", yearPublished=" + yearPublished + ", stock=" + stock + ", fkPublisher=" + fkPublisher
                + ", authors=" + authors + ", registrationDate=" + registrationDate + ", registrationName="
                + registrationName + ", registrationUpdateDate=" + registrationUpdateDate + ", registrationUpdateName="
                + registrationUpdateName + ", deleted=" + deleted + "]";
    }

    
    

}

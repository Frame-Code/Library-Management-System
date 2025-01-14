package com.company.system.model;

import java.io.Serializable;
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
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBook")
    private Long idBook;

    @Column(unique = true, nullable = false, name = "isbn")
    private String isbn;
    
    @Column(unique = true, nullable = false, name = "title")
    private String title;
    
    @Column(unique = true, nullable = false, name = "description", length = 255)
    private String description;
    
    @Column(nullable = false, name = "yearPublished")
    private LocalDate yearPublished;
    
    @Column(nullable = false, name = "stockToLoan")
    private Integer stockToLoan;
    
    @Column(nullable = false, name = "generalStock")
    private Integer generalStock;

    @ManyToOne
    @JoinColumn(name = "fkPublisher")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "fkCategory")
    private Category category;

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
    
    @Column(name = "isDeleted", nullable = false)
    private boolean deleted;

    public Book() {
    }

    public Book(String isbn, String title, String description, LocalDate yearPublished, Integer stockToLoan,
            Integer generalStock, Publisher publisher, Category category, List<Author> authors,
            LocalDate registrationDate, String registrationName, LocalDate registrationUpdateDate,
            String registrationUpdateName, boolean deleted) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.yearPublished = yearPublished;
        this.stockToLoan = stockToLoan;
        this.generalStock = generalStock;
        this.publisher = publisher;
        this.category = category;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public Integer getStockToLoan() {
        return stockToLoan;
    }

    public void setStockToLoan(Integer stockToLoan) {
        this.stockToLoan = stockToLoan;
    }

    public void setGeneralStock(Integer generalStock) {
        this.generalStock = generalStock;
    }

    public Integer getGeneralStock() {
        return generalStock;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        result = prime * result + ((stockToLoan == null) ? 0 : stockToLoan.hashCode());
        result = prime * result + ((generalStock == null) ? 0 : generalStock.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
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
        if (stockToLoan == null) {
            if (other.stockToLoan != null)
                return false;
        } else if (!stockToLoan.equals(other.stockToLoan))
            return false;
        if (generalStock == null) {
            if (other.generalStock != null)
                return false;
        } else if (!generalStock.equals(other.generalStock))
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
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
                + ", yearPublished=" + yearPublished + ", stockToLoan=" + stockToLoan + ", generalStock=" + generalStock
                + ", publisher=" + publisher + ", category=" + category + ", authors=" + authors + ", registrationDate="
                + registrationDate + ", registrationName=" + registrationName + ", registrationUpdateDate="
                + registrationUpdateDate + ", registrationUpdateName=" + registrationUpdateName + ", deleted=" + deleted
                + "]";
    }
}

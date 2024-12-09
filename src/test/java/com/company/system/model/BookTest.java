package com.company.system.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.company.system.dao.impl.CategoryDaoImpl;

public class BookTest {
    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        Book book = new Book("JPKL-4", "50 sombras de grey", "Un libro para aprender a coger de maneras peculiares", 
            LocalDate.now(), 5, null, new CategoryDaoImpl().findByName(Category.categoryAI), 
            null, LocalDate.now(), "Admin", null, null, false
        );

        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}

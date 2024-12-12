package com.company.system.model;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class PublisherTest {
    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        Publisher publisher = new Publisher("Editoral1", LocalDate.now(), 
            "User1", null, null, 
            false
        );

        try {
            em.getTransaction().begin();
            em.persist(publisher);
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
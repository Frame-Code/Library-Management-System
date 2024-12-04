package com.company.system.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Role role = new Role("Administrador", 
                LocalDate.now(), 
                "@artist-code", 
                null,
                null,
                false);

                em.persist(role);
                em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error");
        } finally {
            em.close();
        }
    }
}

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
public class RoleTest {

    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        Role role = new Role("Administrador", 
            LocalDate.now(), 
            "@artist-code", 
            null,
            null,
            false
            );

        try {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error: no se puede crear el rol");
        } finally {
            em.close();
        }
    }
}

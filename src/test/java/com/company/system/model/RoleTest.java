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
        Role role1 = new Role(Role.roleLibrarian, 
            LocalDate.now(), 
            "@artist-code", 
            null,
            null,
            false
        );
        Role role2 = new Role(Role.roleStudent, 
            LocalDate.now(), 
            "@artist-code", 
            null,
            null,
            false
        );

        try {
            em.getTransaction().begin();
            em.persist(role1);
            em.persist(role2);
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

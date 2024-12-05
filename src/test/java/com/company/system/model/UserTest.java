package com.company.system.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.company.system.dao.impl.RoleDaoImpl;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserTest {
    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        Role role = new RoleDaoImpl().findById(1L);
        System.out.println(role);
        User usr = new User(654654654L, 
            "Daniel Mora", 
            "Mora Cantillo", 
            "morai@hotmail.com", 
            "fdsfedsfdfdf", 
            LocalDate.now(), 
            role, 
            LocalDate.now(), 
            "User1", 
            null, 
            null, 
            false
        );

        try {
            em.getTransaction().begin();
            em.persist(usr);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException("Error: no se puede crear el rol");
        } finally {
            em.close();
        }
    }

}

package com.company.system.model;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.company.system.dao.impl.RoleDaoImpl;
import com.company.system.service.EncryptationService;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserTest {
    @Test
    void createTableTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        User usr = new User(941239261L, 
            "Daniel Isur", 
            "Mora Cantillo", 
            "morai@hotmail.com", 
            new EncryptationService().encryptPassword("MiContra"),
            LocalDate.now(), 
            new RoleDaoImpl().findByName(Role.roleLibrarian), 
            LocalDate.now(), 
            "@artist-code", 
            null, 
            null, 
            false
        );

        User usr1 = new User(941239253L, 
            "Genesis Sarai", 
            "Mora Cantillo", 
            "genesita-1995@hotmail.com", 
            new EncryptationService().encryptPassword("MiContraseña"),
            LocalDate.now(), 
            new RoleDaoImpl().findByName(Role.roleStudent), 
            LocalDate.now(), 
            "@artist-code", 
            null, 
            null, 
            false
        );

        try {
            em.getTransaction().begin();
            //em.persist(usr);
            //em.persist(usr1);
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

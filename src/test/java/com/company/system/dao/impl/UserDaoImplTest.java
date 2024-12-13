package com.company.system.dao.impl;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.company.system.model.Role;
import com.company.system.model.User;
import com.company.system.service.EncryptationService;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserDaoImplTest {
    @Test
    void testFindByIdCard() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByIdCard(654654654L);
        System.out.println(user);
    }

    @Test
    void testCreate() {
        EncryptationService encrypte = new EncryptationService();
        String hashedPassword = encrypte.encryptPassword("Mic0ntr@seña");
        Role role = new RoleDaoImpl().findById(1L);
        User user = new User(941239261L, 
            "Daniel Isur", 
            "Mora Cantillo", 
            "moraisurcan@hotmail.com", 
            hashedPassword, 
            LocalDate.now(), 
            role, 
            LocalDate.now(), 
            "User1", 
            null,
            null,
            false
        );

        //System.out.println(new UserDaoImpl().create(user));
    }
}

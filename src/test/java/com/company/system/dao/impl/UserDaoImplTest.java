package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Role;
import com.company.system.model.User;
import com.company.system.service.EncryptationService;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserDaoImplTest {
    UserDao userDao;
    @BeforeEach
    void setUp() {
        this.userDao = new UserDaoImpl();
    }


    @Test
    void testFindByIdCard() {
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

        System.out.println(userDao.create(user));
    }

    @Test
    void testFindById() {
        System.out.println(userDao.findById(4L));
    }


    @Test
    void testDeleteByID() {
        System.out.println(userDao.deleteByID(4L));
    }
    
    
    @Test
    void testDeleteByIdCard() {
        System.out.println(userDao.deleteByIdCard(941239261L));
    }


    @Test
    void testUpdate() {
        User user = userDao.findById(5L);
        user.setDeleted(false);
        System.out.println(userDao.update(user));
    }


    @Test
    void testFindAllIncludeDeleted() {
        List<User> users = userDao.findAllIncludeDeleted();
        users.forEach(user -> {
            System.out.println(user);
        });
    }


    @Test
    void testFindAll() {
        List<User> users = userDao.findAll();
        users.forEach(user -> {
            System.out.println(user);
        });
    }

}

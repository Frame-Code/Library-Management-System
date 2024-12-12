package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.RoleDao;
import com.company.system.model.Role;

/**
 * @author artist-code (Daniel Mora Cantillo)
 */
public class RoleDaoImplTest {
    RoleDao roleDao;
    @BeforeEach
    void setUp() {
        this.roleDao = new RoleDaoImpl();
    }

    @Test
    void testCreate() {
        Role rol = new Role("Test", LocalDate.now(), "Admin",
         null, null, false);
        System.out.println(roleDao.create(rol));
    }

    @Test
    void testDeleteByID() {
        System.out.println(roleDao.deleteByID(1L));
    }

    @Test
    void testFindAll() {
        List<Role> roles = roleDao.findAll();
        roles.forEach(rol -> {
            System.out.println(rol);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Role> roles = roleDao.findAllIncludeDeleted();
        roles.forEach(rol -> {
            System.out.println(rol);
        });
    }

    @Test
    void testFindById() {
        System.out.println(roleDao.findById(1L));
    }

    @Test
    void testFindByName() {
        System.out.println(roleDao.findByName(Role.roleLibrarian));
    }

    @Test
    void testUpdate() {
        Role role = roleDao.findByName(Role.roleLibrarian);
        role.setRegistrationName("Admin");
        System.out.println(roleDao.update(role));
    }
}

package com.company.system.dao.impl;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.system.dao.interfaces.FineDao;
import com.company.system.model.Fine;

public class FineDaoImplTest {
    FineDao fineDao;

    @BeforeEach
    void setUp() {
        fineDao = new FineDaoImpl();
    }

    @Test
    void testCreate() {
        Fine fine = new Fine(new UserDaoImpl().findById(21L), 
        LocalDate.of(2024, 12, 25), LocalDate.now(), "Admin",
         null, null, false);
        //System.out.println(fineDao.create(fine));
    }

    @Test
    void testDeleteByID() {
        //Fine fine = fineDao.findById(21L);
        System.out.println(fineDao.deleteByID(21L));

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindAllIncludeDeleted() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByIdIncludeDeleted() {

    }

    @Test
    void testFindByUser() {

    }

    @Test
    void testUpdate() {

    }
}

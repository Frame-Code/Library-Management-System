package com.company.system.dao.impl;

import java.time.LocalDate;
import java.util.List;

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
        System.out.println(fineDao.deleteByID(1L));

    }

    @Test
    void testFindAll() {
        List<Fine> fines = fineDao.findAll();
        fines.forEach(fine -> {
            System.out.println(fine);
        });
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Fine> fines = fineDao.findAllIncludeDeleted();
        fines.forEach(fine -> {
            System.out.println(fine);
        });
    }

    @Test
    void testFindById() {
        System.out.println(fineDao.findById(2L));
        System.out.println(fineDao.findById(1L));
    }

    @Test
    void testFindByIdIncludeDeleted() {
        System.out.println(fineDao.findByIdIncludeDeleted(2L));
        System.out.println(fineDao.findByIdIncludeDeleted(1L));
    }

    @Test
    void testFindByUser() {
        List<Fine> fines = fineDao.findByUser(new UserDaoImpl().findById(21L));
        fines.forEach(fine -> {
            System.out.println(fine);
        });
    }

    @Test
    void testUpdate() {
        Fine fine = fineDao.findByIdIncludeDeleted(1L);
        fine.setDeadline(LocalDate.of(2024, 11, 25));
        System.out.println(fineDao.update(fine));
    }
}

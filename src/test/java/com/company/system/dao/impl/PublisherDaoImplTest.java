package com.company.system.dao.impl;

import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.dao.impl.PublisherDaoImpl;
import com.company.system.model.Publisher;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PublisherDaoImplTest {
    PublisherDao publisherDao;

    @BeforeEach
    void setUP() {
        this.publisherDao = new PublisherDaoImpl();
    }

    @Test
    void testFindAll() {
        List<Publisher> publishers = publisherDao.findAll();
        publishers.forEach(publisher -> {
            System.out.println(publisher.getName());
        });
    }

    @Test
    void testFindByName() {
        Publisher publisher = publisherDao.findByName("Editoral1");
        System.out.println(publisher);
    }

    @Test
    void testCreate() {
        Publisher publisher = new Publisher("Editorial2", LocalDate.now(), "Admin", 
        null, null, false);
  //      System.out.println(publisherDao.create(publisher));
    }

    @Test
    void testDeleteByID() {
        System.out.println(publisherDao.deleteByID(1L));    
    }

    @Test
    void testFindAllIncludeDeleted() {
        List<Publisher> publishers = publisherDao.findAllIncludeDeleted();
        publishers.forEach(publisher -> {
            System.out.println(publisher);
        });
    }

    @Test
    void testFindById() {
        Publisher publisher = publisherDao.findById(1L);
        Publisher publisher1 = publisherDao.findById(3L);
        System.out.println(publisher);
        System.out.println(publisher1);
    }

    @Test
    void testFindByIdIncludeDeleted() {
        Publisher publisher = publisherDao.findById(1L);
        System.out.println(publisher);
    } 

    @Test
    void testUpdate() {
        Publisher publisher = publisherDao.findByIdIncludeDeleted(1L);
        publisher.setDeleted(false);
        System.out.println(publisherDao.update(publisher));
    }

}

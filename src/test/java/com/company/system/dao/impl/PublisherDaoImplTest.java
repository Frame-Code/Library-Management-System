package com.company.system.dao.impl;

import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.dao.impl.PublisherDaoImpl;
import com.company.system.model.Publisher;

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

}

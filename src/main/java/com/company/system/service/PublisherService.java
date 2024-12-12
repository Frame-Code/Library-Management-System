package com.company.system.service;

import java.util.List;

import com.company.system.dao.impl.PublisherDaoImpl;
import com.company.system.dao.interfaces.PublisherDao;
import com.company.system.model.Publisher;

public class PublisherService {
    private final PublisherDao publisherDao;

    public PublisherService() {
        this.publisherDao = new PublisherDaoImpl();
    }

    public List<Publisher> getPublisher() {
        return publisherDao.findAll();
    }

    
}

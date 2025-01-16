package com.company.system.dao.interfaces;

import com.company.system.model.Publisher;

public interface PublisherDao extends Dao<Publisher>{
    Publisher findByName(String name);
}
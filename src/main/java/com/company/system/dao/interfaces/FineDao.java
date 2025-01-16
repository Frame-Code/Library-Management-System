package com.company.system.dao.interfaces;

import java.util.List;

import com.company.system.model.Fine;
import com.company.system.model.User;

public interface FineDao extends Dao<Fine> {
    List<Fine> findByUser(User user);
}

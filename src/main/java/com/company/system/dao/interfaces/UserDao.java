package com.company.system.dao.interfaces;

import com.company.system.model.User;

public interface UserDao extends Dao<User>{
    User findByIdCard(Long idCard);
    User findByIdCard(Long idCard, String role);
    User findByEmail(String email);
    boolean deleteByIdCard(Long idCardUser);
    
}

package com.company.system.service;

import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserService {
    private UserDao userDao;
    private EncryptationService encrypte;
    public UserService() {
        userDao = new UserDaoImpl();
        encrypte = new EncryptationService();
    }

    private User getUser(Long idCard) {
        return userDao.findByIdCard(idCard);
    }

    public boolean userExists(Long idCard) {
        User user = getUser(idCard);
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

    public User login(Long idCard, String password) {
        String passwordHashed = encrypte.encryptPassword(password);
        User user = getUser(idCard);
        if(user.getPasswordHash().equals(passwordHashed)) {
            return user;
        } else {
            return null;
        }
    }
}

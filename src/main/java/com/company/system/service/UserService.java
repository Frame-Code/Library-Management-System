package com.company.system.service;

import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Role;
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

    private boolean userExists(Long idCard, String role) {
        User user = userDao.findByIdCard(idCard, role);
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean librarianExists(Long idCard) {
        return userExists(idCard, Role.roleLibrarian);
    }

    public boolean studentExists(Long idCard) {
        return userExists(idCard, Role.roleStudent);
    }

    public User login(Long idCard, String password) {
        String passwordHashed = encrypte.encryptPassword(password);
        User user = userDao.findByIdCard(idCard);
        if(user.getPasswordHash().equals(passwordHashed)) {
            return user;
        } else {
            return null;
        }
    }
}

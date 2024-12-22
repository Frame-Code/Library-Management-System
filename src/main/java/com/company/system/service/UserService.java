package com.company.system.service;

import java.time.LocalDate;

import com.company.system.dao.impl.RoleDaoImpl;
import com.company.system.dao.impl.UserDaoImpl;
import com.company.system.dao.interfaces.RoleDao;
import com.company.system.dao.interfaces.UserDao;
import com.company.system.model.Role;
import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final EncryptationService encrypte;
    
    public UserService() {
        this.userDao = new UserDaoImpl();
        this.roleDao = new RoleDaoImpl();
        this.encrypte = new EncryptationService();
    }
    
    public User getStudentByIdCard(Long idCardUser) {
        return userDao.findByIdCard(idCardUser, Role.roleStudent);
    }
    
    public User getLibrarianByIdCard(Long idCardUser) {
        return userDao.findByIdCard(idCardUser, Role.roleLibrarian);
    }

    private boolean userExists(Long idCard, String role) {
        User user = userDao.findByIdCard(idCard, role);
        return user != null;
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

    public User getLoggedUser(Long idCard) {
        return userDao.findByIdCard(idCard);
    }

    public boolean RegisterStudent(String names, String surNames, String email, Long idCardUser, 
    LocalDate bornDate, String passwordPlain) {
        String passwordHash = encrypte.encryptPassword(passwordPlain);
        User user = new User(idCardUser, names, surNames, email, passwordHash, bornDate, 
        roleDao.findByName(Role.roleStudent), LocalDate.now(), names + " " + surNames + " ci: " + idCardUser, null, 
        null, 
        false
        );
        return userDao.create(user);
    }

    public boolean isAvailableEmail(String email) {
        User user = userDao.findByEmail(email);
        return user == null;
    }
    
    public boolean isAvailableIdCard(Long idCardUser) {
        User user = userDao.findByIdCard(idCardUser);
        return user == null;
    }

}

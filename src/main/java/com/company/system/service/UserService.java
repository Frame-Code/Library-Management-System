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
/**
 * Clase encargada de gestionar las operaciones relacionadas con los usuarios.
 * Esta clase interactúa con la capa de acceso a datos a través de las interfaces UserDao y RoleDao.
 * Además, maneja el proceso de encriptación de contraseñas a través de EncryptationService.
 */
public class UserService {

    // Atributos que representan los objetos de acceso a datos y encriptación.
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final EncryptationService encrypte;

    /**
     * Constructor de la clase UserService. Inicializa los objetos userDao, roleDao y encrypte
     * utilizando sus respectivas implementaciones concretas.
     */
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

    /**
     * Verifica si un usuario existe en la base de datos basado en su número de tarjeta de identidad
     * y el rol proporcionado.
     * 
     * @param idCard El número de tarjeta de identidad del usuario.
     * @param role El rol del usuario (ej. "librarian" o "student").
     * @return true si el usuario existe, false en caso contrario.
     */
    private boolean userExists(Long idCard, String role) {
        User user = userDao.findByIdCard(idCard, role);
        return user != null;
    }

    /**
     * Verifica si un usuario con el rol de bibliotecario existe en la base de datos.
     * 
     * @param idCard El número de tarjeta de identidad del usuario.
     * @return true si el bibliotecario existe, false en caso contrario.
     */
    public boolean librarianExists(Long idCard) {
        return userExists(idCard, Role.roleLibrarian);
    }

    /**
     * Verifica si un usuario con el rol de estudiante existe en la base de datos.
     * 
     * @param idCard El número de tarjeta de identidad del usuario.
     * @return true si el estudiante existe, false en caso contrario.
     */
    public boolean studentExists(Long idCard) {
        return userExists(idCard, Role.roleStudent);
    }

    /**
     * Permite a un usuario iniciar sesión proporcionando su número de tarjeta de identidad
     * y su contraseña. La contraseña se encripta antes de compararla.
     * 
     * @param idCard El número de tarjeta de identidad del usuario.
     * @param password La contraseña proporcionada por el usuario.
     * @return El usuario si la contraseña es correcta, o null si es incorrecta.
     */
    public User login(Long idCard, String password) {
        // Encripta la contraseña proporcionada por el usuario
        String passwordHashed = encrypte.encryptPassword(password);
        User user = userDao.findByIdCard(idCard);
        // Compara la contraseña encriptada con la almacenada en la base de datos
        if(user.getPasswordHash().equals(passwordHashed)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * Obtiene el usuario que está actualmente logueado.
     * 
     * @param idCard El número de tarjeta de identidad del usuario.
     * @return El usuario correspondiente al idCard.
     */
    public User getLoggedUser(Long idCard) {
        return userDao.findByIdCard(idCard);
    }

    /**
     * Registra un nuevo estudiante en el sistema. La contraseña se encripta antes de ser almacenada.
     * 
     * @param names El nombre del estudiante.
     * @param surNames Los apellidos del estudiante.
     * @param email El correo electrónico del estudiante.
     * @param idCardUser El número de tarjeta de identidad del estudiante.
     * @param bornDate La fecha de nacimiento del estudiante.
     * @param passwordPlain La contraseña sin encriptar proporcionada por el estudiante.
     * @return true si el estudiante fue registrado exitosamente, false en caso contrario.
     */
    public boolean RegisterStudent(String names, String surNames, String email, Long idCardUser, 
                                   LocalDate bornDate, String passwordPlain) {
        // Encripta la contraseña proporcionada
        String passwordHash = encrypte.encryptPassword(passwordPlain);
        // Crea un nuevo objeto de usuario con la información proporcionada
        User user = new User(idCardUser, names, surNames, email, passwordHash, bornDate, 
                             roleDao.findByName(Role.roleStudent), LocalDate.now(), names, null, 
                             null, false);
        // Intenta registrar el nuevo usuario en la base de datos
        return userDao.create(user);
    }

    /**
     * Verifica si un correo electrónico está disponible para su uso, es decir, si no está registrado
     * en el sistema.
     * 
     * @param email El correo electrónico a verificar.
     * @return true si el correo electrónico está disponible, false en caso contrario.
     */
    public boolean isAvailableEmail(String email) {
        User user = userDao.findByEmail(email);
        return user == null;
    }
    
    /**
     * Verifica si un número de tarjeta de identidad está disponible, es decir, si no está asociado
     * a ningún usuario en el sistema.
     * 
     * @param idCardUser El número de tarjeta de identidad a verificar.
     * @return true si la tarjeta de identidad está disponible, false en caso contrario.
     */
    public boolean isAvailableIdCard(Long idCardUser) {
        User user = userDao.findByIdCard(idCardUser);
        return user == null;
    }

}

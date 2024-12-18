package com.company.system.service;


import org.junit.jupiter.api.Test;

import com.company.system.model.User;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class UserServiceTest {
    @Test
    void testLogin() {
        UserService userService = new UserService();
        User user = userService.login(941239261L, "MiContra");
        User user1 = userService.login(941239253L, "MiContraseña");
        /*System.out.println(user);
        System.out.println(user1)*/
    }

    @Test
    void testRegister() {
        UserService userService = new UserService();
        //System.out.println(userService.RegisterStudent("Isur", "Cantilo", "mail1@mail.com",
         //9412392679L, LocalDate.now(), "suCOntraseni@"));
        
    }

    @Test
    void testCheckEmail() {
        UserService userService = new UserService();
        System.out.println(userService.isAvailableEmail("morai@hotmail.com"));
    }

    @Test
    void testIsAvailableIdCard() {
        UserService userService = new UserService();
        System.out.println(userService.isAvailableIdCard(941239253L));
        
    }
}

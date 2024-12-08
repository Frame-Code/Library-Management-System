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
        User user = userService.login(941239261L, "Mic0ntr@seña");
    }
}

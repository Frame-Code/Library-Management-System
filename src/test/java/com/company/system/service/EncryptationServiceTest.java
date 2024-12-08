package com.company.system.service;

import org.junit.jupiter.api.Test;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */

public class EncryptationServiceTest {
    @Test
    void testEncryptPassword() {
        String password = "A p@swrrod_3xamplé";
        EncryptationService encryptationService = new EncryptationService();
        System.out.println(encryptationService.encryptPassword(password));
    }
}

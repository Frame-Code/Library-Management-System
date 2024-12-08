package com.company.system.service;

import java.security.MessageDigest; //Clase que permite usar algortimos de hash como MD5 O SHA-256
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class EncryptationService {
    public String encryptPassword(String password) {
        try {
            // Algoritmo de hash para encriptar la contraseña
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            // Convertir el hash a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

}

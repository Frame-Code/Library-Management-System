package com.company.system.controller;

import java.time.LocalDate;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public interface Utils {
    
    default  LocalDate getDate(int day, String month, int year) {
        int monthNumber;
        switch (month) {
            case "Enero" -> monthNumber = 1;
            case "Febrero" -> monthNumber = 2;
            case "Marzo" -> monthNumber = 3;
            case "Abril" -> monthNumber = 4;
            case "Mayo" -> monthNumber = 5;
            case "Junio" -> monthNumber = 6;
            case "Julio" -> monthNumber = 7;
            case "Agosto" -> monthNumber = 8;
            case "Septiembre" -> monthNumber = 9;
            case "Octubre" -> monthNumber = 10;
            case "Noviembre" -> monthNumber = 11;
            case "Diciembre" -> monthNumber = 12;
            default -> throw new AssertionError();
        }
        
        return LocalDate.of(year, monthNumber, day);
    }
    
}

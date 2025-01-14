package com.company.system.controller;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public interface UtilsController {

    static Color btnExited = new Color(56, 75, 147);
    static Color btnEntered = new Color(26, 54, 148);
    static Color btnDeleteEntered = new Color(167,89,89);
    static Color btnDeleteExited = new Color(133, 71, 71);

    public final static Color pnlEntered = new Color(200, 206, 238);
    public final static Color pnlExited = new Color(255, 255, 255);

    default int getMonthByName(String month) {
        int monthNumber;
        month = month.trim(); //eliminar espacios en blanco de la cadena
        switch (month) {
            case "Enero" ->
                monthNumber = 1;
            case "Febrero" ->
                monthNumber = 2;
            case "Marzo" ->
                monthNumber = 3;
            case "Abril" ->
                monthNumber = 4;
            case "Mayo" ->
                monthNumber = 5;
            case "Junio" ->
                monthNumber = 6;
            case "Julio" ->
                monthNumber = 7;
            case "Agosto" ->
                monthNumber = 8;
            case "Septiembre" ->
                monthNumber = 9;
            case "Octubre" ->
                monthNumber = 10;
            case "Noviembre" ->
                monthNumber = 11;
            case "Diciembre" ->
                monthNumber = 12;
            default ->
                throw new AssertionError();
        }

        return monthNumber;
    }

    default LocalDate getDate(int day, String month, int year) {
        return LocalDate.of(year, getMonthByName(month), day);
    }

   
}

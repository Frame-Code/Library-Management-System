package com.company.system.controller;

import java.awt.Color;
import java.time.LocalDate;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public interface UtilsController {

    public final static Color btnExited = new Color(56, 75, 147);
    public final static Color btnEntered = new Color(26, 54, 148);

    public final static Color pnlEntered = new Color(200, 206, 238);
    public final static Color pnlExited = new Color(255, 255, 255);

    default int getMonthByName(String month) {
        int monthNumber;
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

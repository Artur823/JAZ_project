package com.example.utils;

import java.text.DecimalFormat;

public class NumberUtils {

    /**
     * Форматирует число с указанным количеством десятичных знаков.
     *
     * @param number   Число для форматирования.
     * @param decimals Количество десятичных знаков.
     * @return Строка с округленным значением или пустая строка, если число null.
     */
    public String formatDecimal(Double number, int decimals) {
        if (number == null) {
            return "";
        }

        StringBuilder pattern = new StringBuilder("0.");
        for (int i = 0; i < decimals; i++) {
            pattern.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern.toString());
        return decimalFormat.format(number);
    }
}
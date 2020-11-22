package com.example.addnewviewonbuttontap.helper;

public class Utils {
    public static Boolean isStringNull(String nullableString) {
        boolean result = true;
        /* && !nullableString.equals("0") && !nullableString.equals("0.0") &&!nullableString.equals("0.00") */
        if (nullableString != null && !nullableString.equals("null") && !nullableString.equals("N/A") && !nullableString.equals("") && !nullableString.equals("[ ]") && !nullableString.equals("[]") && !nullableString.equals("{}")) {
            result = false;
        }
        return result;
    }
}

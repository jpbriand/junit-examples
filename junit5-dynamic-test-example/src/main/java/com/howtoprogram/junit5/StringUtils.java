package com.howtoprogram.junit5;

public class StringUtils {

    static boolean isBlank(String ptext) {
        return ptext == null || ptext.trim().length() == 0;
    }
}

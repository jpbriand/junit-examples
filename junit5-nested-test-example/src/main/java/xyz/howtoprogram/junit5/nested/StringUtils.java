package xyz.howtoprogram.junit5.nested;

public class StringUtils {


    public static boolean isBlank(String ptext) {
        return ptext == null || ptext.trim().length() == 0;
    }

    public static boolean isNotBlank(String ptext) {
        return !isBlank(ptext);
    }
}

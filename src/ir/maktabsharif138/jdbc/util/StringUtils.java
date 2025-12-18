package ir.maktabsharif138.jdbc.util;

import java.util.Objects;

public class StringUtils {

    public static int findLastIndexOf(String s1, String s2) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);
        return s1.lastIndexOf(s2);
    }

    public int findLastIndexOfNonStatic(String s1, String s2) {
        return s1.lastIndexOf(s2);
    }

}

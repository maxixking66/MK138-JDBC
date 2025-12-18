package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.StringUtils;

public class JDBCApplication {

    static StringUtils stInstance = new StringUtils();


    static void main() {

        CharToStringFactory factory = (chars) -> {
            return new String(chars);
        };

        CharToStringFactory factory1 = String::new;

    }
}

interface CharToStringFactory {
    String create(char[] chars);
}
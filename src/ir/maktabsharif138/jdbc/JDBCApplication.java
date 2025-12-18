package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.LastIndexFinder;
import ir.maktabsharif138.jdbc.util.StringUtils;

public class JDBCApplication {

    static StringUtils stInstance = new StringUtils();


    static void main() {


//        LastIndexFinder finder = (s1, s2) -> stInstance.findLastIndexOfNonStatic(s1, s2);
        LastIndexFinder finder = stInstance::findLastIndexOfNonStatic;

    }
}
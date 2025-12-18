package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.LastIndexFinder;
import ir.maktabsharif138.jdbc.util.StringUtils;

public class JDBCApplication {

    static void main() {

//        LastIndexFinder finder = (first, second) -> {
//            return StringUtils.findLastIndexOf(second, first);
//        };
        LastIndexFinder finder = StringUtils::findLastIndexOf;

    }
}
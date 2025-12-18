package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.LastIndexFinder;

public class JDBCApplication {

    static void main() {

        LastIndexFinder finder = (String first, String second) -> {
            return first.lastIndexOf(second);
        };
        LastIndexFinder ssss = String::compareTo;

        A a = (B b) -> {
            return b.logic();
        };

        A a1 = B::logic;


    }
}

interface A {
    float test(B b);
}

class B {
    float logic() {
        return 58.5f;
    }
}
package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.LastIndexFinder;

public class JDBCApplication {

    static void main() {

        LastIndexFinder finder = (String first, String second) -> {
            return first.lastIndexOf(second);
        };
        LastIndexFinder ssss = String::compareTo;

        A a = (B b, C c) -> {
            return b.logic(c);
        };

        A a1 = B::logic;


    }
}

interface A {
    float test(B b, C c);
}

class B {
    float logic(C c) {
        return 58.5f;
    }
}

class C {
}
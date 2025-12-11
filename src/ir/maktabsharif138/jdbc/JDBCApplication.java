package ir.maktabsharif138.jdbc;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        logic(
                new A() {
                    @Override
                    public void doSomething() {
                        System.out.println("first");
                    }
                }
        );

        logic(
                () -> {
                    System.out.println("second");
                }
        );

        logic(() -> System.out.println("third"));
    }

    static void logic(A a) {
        a.doSomething();
    }
}

interface A {

    void doSomething();

    default void test() {

    }

    static void doStatic() {

    }
}

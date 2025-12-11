package ir.maktabsharif138.jdbc;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JDBCApplication {

    static void main() {

        MyFunctionalInterface<String> mfi = s -> System.out.println(s.toUpperCase());
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
//        Predicate<String> predicate = s -> System.out.println(s.toLowerCase());
//        Predicate<String> predicate = s -> Objects.equals(s, "mohsen");
        Predicate<String> predicate = s -> {
            System.out.println(s.toUpperCase());
            return Objects.equals(s, "mohsen");
        };

        Predicate<String> greaterThanTenLength = w -> w.length() > 10;

        System.out.println("mat predicate: " + greaterThanTenLength.test("mat"));
        System.out.println("mohsen predicate: " + greaterThanTenLength.test("mohsen"));
        System.out.println("mohsen asgari predicate: " + greaterThanTenLength.test("mohsen asgari"));

        Predicate<Integer> greaterThanTen = num -> num > 10;

        System.out.println("0 predicate: " + greaterThanTen.test(0));
        System.out.println("50 predicate: " + greaterThanTen.test(50));
        System.out.println("50 predicate: " + (50 > 10));
        System.out.println("11 asgari predicate: " + greaterThanTen.test(11));
    }
}
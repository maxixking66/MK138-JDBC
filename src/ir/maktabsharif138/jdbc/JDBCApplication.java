package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JDBCApplication {

    static void main() {

        List<String> words = new ArrayList<>();
        words.add("1");
        words.add("2");
        words.add("3");
        words.add("4");
        words.add("3");
        words.add("2");

        words.stream().distinct().peek(System.out::println).limit(1).forEach(System.out::println);
    }

    private static void sendSms(String number) {

    }

    private static List<Integer> getRandomNumbers() {
        return List.of(
                1, 2, 3, 4, 6, 8, 9
        );
    }

    private static Collection<User> getRandomUsers() {
        return List.of();
    }
}


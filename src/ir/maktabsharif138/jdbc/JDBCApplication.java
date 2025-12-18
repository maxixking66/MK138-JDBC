package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    static void main() {

        Collection<User> users = getRandomUsers();

//        u -> u.getId()


        Stream<String> stringStream = users.stream().flatMap(u -> Stream.of(u.getPrimaryMobileNumber(), u.getSecondaryMobileNumber()));

        List<String> texts = new ArrayList<>();
        texts.add("my name is mohsen");
        texts.add("my family is asgari");
        texts.add("my age is 32 50 60");

        texts.stream().flatMap(t -> Arrays.stream(t.split(" "))).forEach(System.out::println);
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


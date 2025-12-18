package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JDBCApplication {

    static void main() {

        List<String> words = new ArrayList<>();
        words.add("1111");
        words.add("222");
        words.add("333");
        words.add("444");
        words.add("333");
        words.add("255");

        long count = words.stream().distinct().count();
        System.out.println(count);

        Collection<User> users = getRandomUsers();

        Map<Integer, User> userIdMap = users.stream().collect(
                Collectors.toMap(
                        User::getId, Function.identity()
                )
        );
        System.out.println(userIdMap);


    }

    private static void sendSms(String number) {

    }

    private static List<Integer> getRandomNumbers() {
        return List.of(
                1, 2, 3, 4, 6, 8, 9
        );
    }

    private static Collection<User> getRandomUsers() {
        return List.of(
                new User(1),
                new User(2),
                new User(3),
                new User(4)
        );
    }
}


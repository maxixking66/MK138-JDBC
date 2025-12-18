package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JDBCApplication {

    static void main() {

        List<String> names = new ArrayList<>();
        names.add("mat");
        names.add("tom");
        names.add("tommy");
        names.add("katy");
        names.add("sara");
        names.add("sam");
        names.add("samy");
        names.add("amy");
        names.add("mohsen");
        names.add("keyvan");
        names.add("keyvan11");


//        3 -> mat, tom, sam, amy
//        4 -> kay, sara, samy
//        5 -> tommy
//        6 -> mohsen, keyvan

        Map<Integer, String> map = names.stream().collect(
                Collectors.toMap(String::length, k -> k, (oldValue, newValue) -> oldValue + "," + newValue)
        );

        System.out.println(map);

        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(collect);

        System.out.println(
                collect.entrySet().stream().collect(Collectors.groupingBy(e -> e.getValue().size()))
        );

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


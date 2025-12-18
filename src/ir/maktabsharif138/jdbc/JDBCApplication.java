package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JDBCApplication {

    static void main() {

        List<String> words = new ArrayList<>();
        words.add("111");
        words.add("222");
        words.add("333");
        words.add("444");

        System.out.println(
                words.stream().reduce("hello", (aggregatedVal, elem) -> {
                    System.out.println("aggregatedVal: " + aggregatedVal);
                    System.out.println("elem: " + elem);
                    String result = aggregatedVal + " # " + elem;
                    System.out.println("iteration result: " + result);
                    System.out.println("-----------------------");
                    return result;
                })
        );

        System.out.println(
                words.stream().reduce((aggregatedVal, elem) -> {
                    System.out.println("aggregatedVal: " + aggregatedVal);
                    System.out.println("elem: " + elem);
                    String result = aggregatedVal + " # " + elem;
                    System.out.println("iteration result: " + result);
                    System.out.println("-----------------------");
                    return result;
                })
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


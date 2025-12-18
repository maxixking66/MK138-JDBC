package ir.maktabsharif138.jdbc;

import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    static void main() {

        List<Integer> numbers = getRandomNumbers();

        Stream<Integer> stream = numbers.stream();
        Stream<Integer> filterStream = stream.filter(num -> {
            System.out.println("in filter method for num: " + num);
            return num % 2 == 0;
        });
        List<Integer> filteredList = filterStream.toList();

        System.out.println(filteredList);
    }

    private static List<Integer> getRandomNumbers() {
        return List.of(
                1, 2, 3, 4, 6, 8, 9
        );
    }
}
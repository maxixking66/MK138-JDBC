package ir.maktabsharif138.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    static void main() {

        List<Integer> numbers = getRandomNumbers();

        List<Integer> filteredNumbers = new ArrayList<>();

        numbers.forEach(num -> {
            if (num % 2 == 0) {
                filteredNumbers.add(num);
            }
        });
        System.out.println(filteredNumbers);

//        numbers.stream().filter(num -> {
//            if (num % 2 == 0) {
//                return true;
//            }
//            return false;
//        })
        Stream<Integer> stream = numbers.stream();
        List<Integer> filteredList = stream
                .filter(num -> num % 2 == 0)
                .toList();

        System.out.println(filteredList);
    }

    private static List<Integer> getRandomNumbers() {
        return List.of(
                1, 2, 3, 4, 6, 8, 9
        );
    }
}
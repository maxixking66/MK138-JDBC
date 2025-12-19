package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.CollectionUtils;

import java.util.*;

public class JDBCApplication {

    static void main() {

        List<Integer> numbers = new ArrayList<>();

        Set<Integer> words = new HashSet<>();

        Collection<Number> numbers1 = new LinkedHashSet<>();
        Collection<Object> objects = new HashSet<>();

        CollectionUtils.addAndReturn(1, numbers);
        CollectionUtils.addAndReturn(2, numbers);

        CollectionUtils.addAndReturn(3, words);

        CollectionUtils.addAndReturn(4, numbers1);
        CollectionUtils.addAndReturn(4.5D, numbers1);
        CollectionUtils.addAndReturn(5, objects);


        System.out.println(numbers);


    }

    public static void put(String key, Long value) {

    }
}


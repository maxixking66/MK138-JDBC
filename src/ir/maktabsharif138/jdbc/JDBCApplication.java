package ir.maktabsharif138.jdbc;

public class JDBCApplication {

    static void main() {

        Printer first = (String word) -> {
            System.out.println(word);
        };

        Printer second = (word) -> {
            System.out.println(word);
        };

        Printer third = word -> System.out.println(word);

        Printer forth = System.out::println;

        NoArg fifth = System.out::println;

//        DoubleArg doubleArg = new DoubleArg() {
//            @Override
//            public void print(String first, String second) {
//                JDBCApplication.logic(first, second);
//            }
//        };

        DoubleArg doubleArg = JDBCApplication::logic;
    }

    public static void logic(String first, String second) {

    }
}

interface DoubleArg {
    void print(String first, String second);
}


interface Printer {

    void print(String s);

}

interface NoArg {
    void print();

}

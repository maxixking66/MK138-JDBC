package ir.maktabsharif138.jdbc;

import java.util.Scanner;

public class JDBCApplication {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        try {
            divide(first, second);
        } catch (IllegalArgumentException e) {
            System.out.println("handling exception, can not divide by zero");
        }

        System.out.println("end");

    }

    private static void divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException();
        }
        System.out.println(first / second);
    }
}

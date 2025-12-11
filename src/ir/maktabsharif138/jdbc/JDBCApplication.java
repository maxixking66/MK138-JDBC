package ir.maktabsharif138.jdbc;

public class JDBCApplication {

    static void main() {

        MyFunctionalInterface myA = (int a, int b) -> {
            int sum = a + b;
            System.out.println(sum);
        };
        myA.test(10, 20);
        myA.test(50, 50);
    }
}
package ir.maktabsharif138.jdbc;

public class JDBCApplication {

    static void main() {

        MyObject o = new MyObject();

        a(o);

    }

    private static void a(MyObject o) {
        b(o);
    }

    private static void b(MyObject o) {
        c(o);
    }

    private static void c(MyObject o) {
        throw o.ex;
//        throw new RuntimeException();
    }

    private static void divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("my custom message");
        }
        System.out.println(first / second);
    }

    static class MyObject {
        RuntimeException ex;

        MyObject() {
            ex = new RuntimeException();
        }
    }
}

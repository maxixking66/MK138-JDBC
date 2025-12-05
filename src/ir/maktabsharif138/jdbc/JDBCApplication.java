package ir.maktabsharif138.jdbc;

import java.sql.SQLException;
import java.util.Random;

public class JDBCApplication {

    static void main() throws SQLException {

        System.out.println(random());

    }

    public static int random() {
        Random random = new Random();
        try {
            int num = random.nextInt(50, 10000);
            if (num % 2 == 0) {
                throw new RuntimeException();
            }
            return num;
        } catch (RuntimeException e) {
            return 10;
        } finally {
            return 0;
        }
    }
}

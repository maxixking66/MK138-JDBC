package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        closeWithoutTryWithResource();
        closeWithTryWithResource();

    }

    private static void closeWithoutTryWithResource() throws SQLException {
        Connection connection = null;

        try {
            connection = ApplicationContext.getInstance().getConnection();


        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void closeWithTryWithResource() {
        try (Connection connection = ApplicationContext.getInstance().getConnection()) {


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

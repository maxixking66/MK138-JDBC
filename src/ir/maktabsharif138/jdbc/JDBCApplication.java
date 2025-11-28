package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {
        Connection connection = DriverManager.getConnection(
                ApplicationProperties.DATABASE_URL,
                ApplicationProperties.DATABASE_USER,
                ApplicationProperties.DATABASE_PASSWORD
        );

        System.out.println();

        connection.close();
    }
}

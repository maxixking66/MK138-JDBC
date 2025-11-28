package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

    static void main() throws SQLException {
        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();
        connection.setAutoCommit(false);


        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("update users set age = 30 where id = 2");
        if (rowsAffected == 1) {
            connection.commit();
        }

        statement.close();
        connection.close();
    }
}

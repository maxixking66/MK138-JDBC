package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {
        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();

        connection.close();
    }
}

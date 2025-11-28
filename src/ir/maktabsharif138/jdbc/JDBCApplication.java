package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class JDBCApplication {

    static void main() throws SQLException {


        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement("update tag set name = ? where id = ?");

        statement.setString(1, "1");
        statement.setInt(2, 1);
        statement.addBatch();

        statement.setString(1, "2");
        statement.setInt(2, 2);
        statement.addBatch();

        statement.setString(1, "4");
        statement.setInt(2, 4);
        statement.addBatch();

        statement.setString(1, "5");
        statement.setInt(2, 5);
        statement.addBatch();

        System.out.println(
                Arrays.toString(statement.executeBatch())
        );

        connection.commit();

        statement.close();
        connection.close();
    }
}

package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCApplication {

    static void main() throws SQLException {


        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        statement.addBatch("update tag set name = 'first' where id = 1");
        statement.addBatch("update tag set name = 'second' where id = 2");
        statement.addBatch("update tag set name = 'forth' where id = 4");
        statement.addBatch("update tag set name = 'fifth' where id = 5");
        System.out.println(
                Arrays.toString(statement.executeBatch())
        );

        connection.commit();

        statement.close();
        connection.close();
    }
}

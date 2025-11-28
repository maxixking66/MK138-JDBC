package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

    static void main() throws SQLException {
        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();
        connection.setAutoCommit(false);

        Tag tag = new Tag();
        tag.setName("f");

        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into tag (name) values ('g')", Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            tag.setId(resultSet.getInt(1));
        }
        connection.commit();

        System.out.println(tag);

        statement.close();
        connection.close();
    }
}

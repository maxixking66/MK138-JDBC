package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

    static void main() throws SQLException {
        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();

        Statement statement = connection.createStatement();
        String sql = "select * from users";
//        String sql = "select id as u_id, username, age from users";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
//            resultSet.getXXX()
            int userId = resultSet.getInt("id");
//            int userId = resultSet.getInt(1);
            String username = resultSet.getString(2);
//            String username = resultSet.getString("username");
            int age = resultSet.getInt("age");

            System.out.format("user information -> id: %d, username: %s, age: %d", userId, username, age);
            System.out.println();
        }


        statement.close();
        connection.close();
    }
}

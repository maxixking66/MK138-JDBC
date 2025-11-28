package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCApplication {

    static void main() throws SQLException {
        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();

        Statement statement = connection.createStatement();
        String sql = "select * from users where id = 10";
//        String sql = "select id as u_id, username, age from users";
        ResultSet resultSet = statement.executeQuery(sql);

        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User();

            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString(2));
            user.setAge(resultSet.getInt("age"));

            users.add(user);
        }

        System.out.println(users);

        statement.close();
        connection.close();
    }
}

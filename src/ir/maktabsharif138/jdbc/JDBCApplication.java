package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {


        ApplicationContext ctx = ApplicationContext.getInstance();
        Connection connection = ctx.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from tag where id = ?");
        preparedStatement.setInt(1, 4);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Tag tag = new Tag();
            tag.setId(resultSet.getInt(1));
            tag.setName(resultSet.getString(2));
            System.out.println(tag);
        } else {
            System.out.println("empty result");
        }


        preparedStatement.close();
        connection.close();
    }
}

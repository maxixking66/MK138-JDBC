package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

//        SQL injection

        Connection connection = ctx.getConnection();

//        String userInput = "sport";
        String userInput = "'); DROP TABLE tbl_tag; --";

//        Statement statement = connection.createStatement();
//
//        String query = "insert into tbl_tag (name) values ('" + userInput + "')";

        PreparedStatement statement = connection.prepareStatement("insert into tbl_tag (name) values (?)");
        statement.setString(1, userInput);

        statement.execute();

        ctx.getConnection().close();
    }
}

package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.UserRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        UserRepository repository = ctx.getUserRepository();
        User user = new User();
        user.setId(1);
        user.setUsername("mat");
        user.setAge(35);
        System.out.println(repository.save(user));

        ctx.getConnection().close();
    }
}

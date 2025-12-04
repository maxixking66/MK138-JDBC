package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.base.CrudRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        CrudRepository repository = ctx.getUserRepository();
        User domain = new User();
        domain.setUsername("new username");
        domain.setAge(50);
        repository.save(domain);

        ctx.getConnection().close();
    }
}

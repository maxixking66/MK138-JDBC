package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.repositories.base.CrudRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        CrudRepository repository = ctx.getUserRepository();

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(10));


        ctx.getConnection().close();
    }
}

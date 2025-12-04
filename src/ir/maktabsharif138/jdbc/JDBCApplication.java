package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.base.CrudRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        CrudRepository repository = ctx.getUserRepository();
        User domain = new User();
        domain.setId(2);
        domain.setUsername("updated username 3");
        domain.setAge(55);
        repository.save(domain);

        Tag tag = new Tag();
        tag.setId(10);
        tag.setName("updated name");
        ctx.getTagRepository().save(tag);

        ctx.getConnection().close();
    }
}

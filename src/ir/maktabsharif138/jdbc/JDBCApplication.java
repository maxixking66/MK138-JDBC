package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.repositories.TagRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        TagRepository tagRepository = ctx.getTagRepository();
        Tag tag = new Tag();
        tag.setId(9);
        tag.setName("football 2");
        System.out.println(tagRepository.save(tag));

        ctx.getConnection().close();
    }
}

package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.repositories.TagRepository;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

import java.sql.SQLException;

public class JDBCApplication {

    static void main() throws SQLException {

        ApplicationContext ctx = ApplicationContext.getInstance();

        TagRepository tagRepository = ctx.getTagRepository();

        System.out.println(tagRepository.findById(1));
        System.out.println(tagRepository.findById(10));


        ctx.getConnection().close();
    }
}

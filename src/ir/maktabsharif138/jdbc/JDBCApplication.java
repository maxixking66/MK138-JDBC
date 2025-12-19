package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.util.ApplicationContext;

public class JDBCApplication {

    static void main() {
        User byId = (User) ApplicationContext.getInstance()
                .getUserRepository()
                .findById(1);

    }
}

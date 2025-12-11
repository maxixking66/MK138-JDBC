package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.User;

import java.util.Objects;
import java.util.function.Function;

public class JDBCApplication {

    static void main() {

//        Consumer
//        Predicate
//        Function
        Function<User, Integer> userToIdFunction = u -> {
            Objects.requireNonNull(u);
            return u.getId();
        };

        User f = new User();
        f.setId(15);
        f.setUsername("mat");

        Integer apply1 = userToIdFunction.apply(f);

        System.out.println(userToIdFunction.apply(f));

        User s = new User();
        s.setId(20);
        System.out.println(userToIdFunction.apply(s));

        Function<User, String> userToUsernameFunction = u -> u.getUsername();
        String apply = userToUsernameFunction.apply(f);

        System.out.println(userToUsernameFunction.apply(f));

    }
}
package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.base.CrudRepository;

public interface UserRepository extends CrudRepository {

    User findByUsername(String username);
}

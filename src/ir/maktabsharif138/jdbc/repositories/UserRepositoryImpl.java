package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.BaseDomain;
import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.base.AbstractCrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl extends AbstractCrudRepository
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<BaseDomain> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    protected BaseDomain getBaseDomain(ResultSet resultSet) {
        User user = new User();
        try {
            user.setUsername(resultSet.getString(2));
            user.setAge(resultSet.getInt(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public String getTableName() {
        return User.TABLE_NAME;
    }

    @Override
    public String[] getInsertColumns() {
        return new String[]{
                User.USERNAME_COLUMN,
                User.AGE_COLUMN
        };
    }

    @Override
    protected void fillPreparedStatementForInsert(BaseDomain baseDomain) {
        try {
            insertStatement.setString(1, ((User) baseDomain).getUsername());
            insertStatement.setInt(2, ((User) baseDomain).getAge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

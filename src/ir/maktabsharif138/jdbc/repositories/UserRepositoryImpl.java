package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.BaseDomain;
import ir.maktabsharif138.jdbc.domains.User;
import ir.maktabsharif138.jdbc.repositories.base.AbstractCrudRepository;

import java.sql.*;
import java.util.List;
import java.util.Objects;

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
    public BaseDomain save(BaseDomain baseDomain) {
        if (Objects.isNull(baseDomain.getId())) {
            return insert(baseDomain);
        } else {
            return update(baseDomain);
        }
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
        return "users";
    }

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;

    private BaseDomain insert(BaseDomain baseDomain) {
        User user = (User) baseDomain;
        PreparedStatement statement = getInsertStatement();
        try {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getAge());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    private BaseDomain update(BaseDomain baseDomain) {
        User user = (User) baseDomain;
        PreparedStatement statement = getUpdateStatement();
        try {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getAge());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public PreparedStatement getInsertStatement() {
        if (insertStatement == null) {
            try {
                insertStatement = connection.prepareStatement(
                        "insert into users (username, age) values (?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return insertStatement;
    }

    public PreparedStatement getUpdateStatement() {
        if (updateStatement == null) {
            try {
                updateStatement = connection.prepareStatement(
                        "update users set username = ?, age = ? where id = ?"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateStatement;
    }
}

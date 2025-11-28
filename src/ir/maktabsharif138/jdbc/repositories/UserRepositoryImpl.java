package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.BaseDomain;
import ir.maktabsharif138.jdbc.domains.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final Connection connection;

    private PreparedStatement findByIdStatement;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public BaseDomain save(BaseDomain baseDomain) {
        return null;
    }

    @Override
    public BaseDomain findById(Integer id) {
        try {
            PreparedStatement statement = getFindByIdStatement();
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    private PreparedStatement getFindByIdStatement() {
        if (findByIdStatement == null) {
            try {
                findByIdStatement = connection.prepareStatement("select * from users where id = ?");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return findByIdStatement;
    }
}

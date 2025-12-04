package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.BaseDomain;
import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.repositories.base.AbstractCrudRepository;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class TagRepositoryImpl extends AbstractCrudRepository implements TagRepository {

    public TagRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Tag findByName(String name) {
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
        Tag tag = new Tag();
        try {
            tag.setName(resultSet.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tag;
    }

    @Override
    public String getTableName() {
        return "tag";
    }

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;

    private BaseDomain insert(BaseDomain baseDomain) {
        Tag tag = (Tag) baseDomain;
        PreparedStatement statement = getInsertStatement();
        try {
            statement.setString(1, tag.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                tag.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tag;
    }

    private BaseDomain update(BaseDomain baseDomain) {
        Tag tag = (Tag) baseDomain;
        PreparedStatement statement = getUpdateStatement();
        try {
            statement.setString(1, tag.getName());
            statement.setInt(2, tag.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tag;
    }

    public PreparedStatement getInsertStatement() {
        if (insertStatement == null) {
            try {
                insertStatement = connection.prepareStatement(
                        "insert into tag (name) values (?)", Statement.RETURN_GENERATED_KEYS
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
                        "update tag set name = ? where id = ?"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateStatement;
    }
}

package ir.maktabsharif138.jdbc.repositories.base;

import ir.maktabsharif138.jdbc.domains.BaseDomain;

import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractCrudRepository implements CrudRepository {

    public static final String QUERY_DELIMITER = ",";

    protected final Connection connection;

    protected PreparedStatement findByIdStatement;

    protected PreparedStatement insertStatement;

    protected PreparedStatement updateStatement;

    protected AbstractCrudRepository(Connection connection) {
        this.connection = connection;
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
    public BaseDomain findById(Integer id) {
        try {
            PreparedStatement statement = getFindByIdStatement();
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                BaseDomain domain = getBaseDomain(resultSet);
                domain.setId(resultSet.getInt(1));
                return domain;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected PreparedStatement getFindByIdStatement() {
        if (findByIdStatement == null) {
            try {
                findByIdStatement = connection.prepareStatement("select * from " + getTableName() + " where id = ?");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return findByIdStatement;
    }

    private BaseDomain insert(BaseDomain baseDomain) {
        PreparedStatement statement = getInsertStatement();
        try {
            fillPreparedStatementForInsert(baseDomain);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                baseDomain.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return baseDomain;
    }

    private BaseDomain update(BaseDomain baseDomain) {
        PreparedStatement statement = getUpdateStatement();
        try {
            fillPreparedStatementForUpdate(baseDomain);
            statement.setInt(getUpdateColumns().length + 1, baseDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return baseDomain;
    }

    protected PreparedStatement getInsertStatement() {
        if (Objects.isNull(insertStatement)) {
            try {
                String[] insertColumns = getInsertColumns();
                String[] questionMarks = new String[insertColumns.length];
                Arrays.fill(questionMarks, "?");
                insertStatement = connection.prepareStatement(
                        "insert into " + getTableName() + " (" + String.join(QUERY_DELIMITER, insertColumns) +
                        ") values (" + String.join(QUERY_DELIMITER, questionMarks) + ")",
                        Statement.RETURN_GENERATED_KEYS
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return insertStatement;
    }

    protected PreparedStatement getUpdateStatement() {
        if (Objects.isNull(updateStatement)) {
            try {
                String[] updateColumns = getUpdateColumns();

                String[] util = new String[updateColumns.length];
                for (int i = 0; i < updateColumns.length; i++) {
                    util[i] = updateColumns[i].concat(" = ?");
                }

                updateStatement = connection.prepareStatement(
                        "update " + getTableName() + " set " + String.join(QUERY_DELIMITER, util) + " where id = ?",
                        Statement.RETURN_GENERATED_KEYS
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateStatement;
    }

    protected abstract BaseDomain getBaseDomain(ResultSet resultSet);

    protected abstract String getTableName();

    protected abstract String[] getInsertColumns();

    protected abstract void fillPreparedStatementForInsert(BaseDomain baseDomain);

    protected abstract String[] getUpdateColumns();

    protected abstract void fillPreparedStatementForUpdate(BaseDomain baseDomain);
}

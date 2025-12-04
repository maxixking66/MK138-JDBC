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
//        Tag tag = (Tag) baseDomain;
//        PreparedStatement statement = getUpdateStatement();
//        try {
//            statement.setString(1, tag.getName());
//            statement.setInt(2, tag.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
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

    protected String generateMarkQuestionsForInsert() {
        String[] insertColumns = getInsertColumns();
        String[] questionMarks = new String[insertColumns.length];
        for (int i = 0; i < insertColumns.length; i++) {
            questionMarks[i] = "?";
        }
        return String.join(QUERY_DELIMITER, questionMarks);
    }

    protected abstract BaseDomain getBaseDomain(ResultSet resultSet);

    protected abstract String getTableName();

    protected abstract String[] getInsertColumns();

    protected abstract void fillPreparedStatementForInsert(BaseDomain baseDomain);
}

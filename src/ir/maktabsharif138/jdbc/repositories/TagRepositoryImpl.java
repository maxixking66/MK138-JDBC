package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.BaseDomain;
import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.repositories.base.AbstractCrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
}

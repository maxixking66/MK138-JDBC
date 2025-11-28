package ir.maktabsharif138.jdbc.repositories.base;

import ir.maktabsharif138.jdbc.domains.BaseDomain;

import java.util.List;

public interface CrudRepository {

    BaseDomain save(BaseDomain baseDomain);

    BaseDomain findById(Integer id);

    List<BaseDomain> findAll();

    void deleteById(Integer id);

    long count();

    boolean existsById(Integer id);

}

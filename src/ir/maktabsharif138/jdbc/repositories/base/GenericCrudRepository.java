package ir.maktabsharif138.jdbc.repositories.base;

import ir.maktabsharif138.jdbc.domains.BaseEntity;

import java.util.List;

public interface GenericCrudRepository<T extends BaseEntity<ID>, ID extends Number> {

    T save(T t);

    T findById(ID id);

    List<T> findAll();

    void deleteById(ID id);

    long count();

    boolean existsById(ID id);

}

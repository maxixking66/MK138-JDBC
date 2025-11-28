package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.Tag;
import ir.maktabsharif138.jdbc.repositories.base.CrudRepository;

public interface TagRepository extends CrudRepository {

    Tag findByName(String name);
}

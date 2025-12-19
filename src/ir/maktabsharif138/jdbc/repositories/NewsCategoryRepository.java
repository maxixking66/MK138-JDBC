package ir.maktabsharif138.jdbc.repositories;

import ir.maktabsharif138.jdbc.domains.NewsCategory;
import ir.maktabsharif138.jdbc.repositories.base.GenericCrudRepository;

import java.util.List;

public interface NewsCategoryRepository
        extends GenericCrudRepository<NewsCategory, Integer> {

    @Override
    NewsCategory save(NewsCategory newsCategory);

    @Override
    NewsCategory findById(Integer integer);

    @Override
    List<NewsCategory> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    boolean existsById(Integer integer);
}

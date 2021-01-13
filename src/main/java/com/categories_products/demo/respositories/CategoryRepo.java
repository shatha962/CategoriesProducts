package com.categories_products.demo.respositories;

import com.categories_products.demo.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
    public List<Category> findAll();
}

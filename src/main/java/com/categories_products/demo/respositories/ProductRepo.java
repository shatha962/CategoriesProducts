package com.categories_products.demo.respositories;

import com.categories_products.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    public List<Product> findAll();
}

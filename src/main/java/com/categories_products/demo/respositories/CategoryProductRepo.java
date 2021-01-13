package com.categories_products.demo.respositories;

import com.categories_products.demo.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepo extends CrudRepository<CategoryProduct, Long> {
}

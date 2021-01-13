package com.categories_products.demo.services;

import com.categories_products.demo.models.Category;
import com.categories_products.demo.models.CategoryProduct;
import com.categories_products.demo.models.Product;
import com.categories_products.demo.respositories.CategoryProductRepo;
import com.categories_products.demo.respositories.CategoryRepo;
import com.categories_products.demo.respositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProCatService {
    private final CategoryRepo catRepo;
    private final ProductRepo proRepo;
    private final CategoryProductRepo catProRepo;

    public ProCatService(CategoryRepo catRepo, ProductRepo proRepo, CategoryProductRepo catProRepo) {
        this.catRepo = catRepo;
        this.proRepo = proRepo;
        this.catProRepo = catProRepo;
    }

    public List<Product> allProducts() {
        return proRepo.findAll();
    }

    public List<Category> allCategories() {
        return catRepo.findAll();
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = catRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public Product createProduct(Product p) {
        return proRepo.save(p);
    }

    public Category createCategory(Category c) {
        return catRepo.save(c);
    }

    public CategoryProduct createCategoryProduct(CategoryProduct c) {
        return catProRepo.save(c);
    }

}

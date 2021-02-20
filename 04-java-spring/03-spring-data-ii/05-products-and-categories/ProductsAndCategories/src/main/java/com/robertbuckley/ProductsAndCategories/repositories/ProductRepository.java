package com.robertbuckley.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertbuckley.ProductsAndCategories.models.Category;
import com.robertbuckley.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoryNotContains(Category category);
	
}

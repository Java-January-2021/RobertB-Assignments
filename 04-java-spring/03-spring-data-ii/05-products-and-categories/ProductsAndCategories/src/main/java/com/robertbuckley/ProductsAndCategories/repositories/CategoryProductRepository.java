package com.robertbuckley.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.robertbuckley.ProductsAndCategories.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}

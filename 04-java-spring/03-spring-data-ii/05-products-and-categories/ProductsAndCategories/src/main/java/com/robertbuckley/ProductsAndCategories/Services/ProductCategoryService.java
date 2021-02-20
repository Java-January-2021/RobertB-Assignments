package com.robertbuckley.ProductsAndCategories.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.ProductsAndCategories.models.Category;
import com.robertbuckley.ProductsAndCategories.models.Product;
import com.robertbuckley.ProductsAndCategories.repositories.CategoryRepository;
import com.robertbuckley.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	@Autowired
	private ProductRepository pRepo;
	
	public ProductCategoryService(CategoryRepository cRepo, ProductRepository pRepo) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
	}
	
	public List<Product> getAllProdcuts(){
		return this.pRepo.findAll();
	}
	
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	public Product updateProduct(Product productToUpdate) {
		return this.pRepo.save(productToUpdate);
	}
	
	public void deleteProduct(Long id) {
		this.pRepo.deleteById(id);
	}
	
	public List<Category> getAllCategories(){
		return this.cRepo.findAll();
	}
	
	public Category getOneCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Category createCategory(Category newCategory) {
		return this.cRepo.save(newCategory);
	}
	
	public Category updateCategory(Category categoryToUpdate) {
		return this.cRepo.save(categoryToUpdate);
	}
	
	public void deleteCategory(Long id) {
		this.cRepo.deleteById(id);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product){
		return cRepo.findByProductNotContains(product);
	}
	
	public List<Product> findProductsNotInCategory(Category category){
		return pRepo.findByCategoryNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> addCategory = product.getCategory();
		addCategory.add(category);
		this.pRepo.save(product);
	}
	
	public void addProductToCategory(Category category, Product product) {
		List<Product> addProduct = category.getProduct();
		addProduct.add(product);
		this.cRepo.save(category);
	}
	
}

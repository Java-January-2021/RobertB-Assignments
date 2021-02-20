package com.robertbuckley.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.robertbuckley.ProductsAndCategories.Services.ProductCategoryService;
import com.robertbuckley.ProductsAndCategories.models.Category;
import com.robertbuckley.ProductsAndCategories.models.CategoryProduct;
import com.robertbuckley.ProductsAndCategories.models.Product;

@Controller
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService pCService;

	@GetMapping("/")
	public String index() {
		return "landing.jsp";
	}
	
	@GetMapping("/product/new")
	public String newProdcuts(@ModelAttribute("products")Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@ModelAttribute("products")Product product) {
		this.pCService.createProduct(product);
		return "redirect:/category/new";
	}
	
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("categories")Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/createCategory")
	public String createCategory(@ModelAttribute("categories") Category category) {
		this.pCService.createCategory(category);
		return "redirect:/category/new";
	}
	
	@GetMapping("/showProduct/{id}")
	public String showProduct(@PathVariable("id")Long id, Model viewModel, @ModelAttribute("categories_products") CategoryProduct categoryProduct) {
		Product showProduct = pCService.getOneProduct(id);
		List<Category> thisProductsCategory = showProduct.getCategory();
		List<Category> allCategory = pCService.getAllCategories();
		List<Category> notInCategory = pCService.findCategoriesNotInProduct(showProduct);
		viewModel.addAttribute("thisProductsCategory",thisProductsCategory);
		viewModel.addAttribute("allCategory", allCategory);
		viewModel.addAttribute("notInCategory", notInCategory);
		viewModel.addAttribute("product", showProduct);
		return "prodcuts.jsp";
	}
	
	@PostMapping("/showProduct/addCategoryToProduct/{id}")
	public String addCategoryToProduct(@RequestParam("category")Long categoryId, @PathVariable("id") Long id) {
		Product thisProduct = this.pCService.getOneProduct(id);
		System.out.println(thisProduct);
		Category categoryToAdd = this.pCService.getOneCategory(categoryId);
		System.out.println(categoryToAdd);
		this.pCService.addCategoryToProduct(thisProduct, categoryToAdd);
		return "redirect:/showProduct/{id}";
	}
	
	@GetMapping("/showCategory/{id}")
	public String showCategory(@PathVariable("id")Long id, Model viewModel, @ModelAttribute("categories_products") CategoryProduct categoryProduct) {
		Category showCategory = pCService.getOneCategory(id);
		List<Product> thisCategoryProduct = showCategory.getProduct();
		List<Product> allProduct = pCService.getAllProdcuts();
		List<Product> notInProduct = pCService.findProductsNotInCategory(showCategory);
		viewModel.addAttribute("category", showCategory);
		viewModel.addAttribute("thisCategoryProduct", thisCategoryProduct);
		viewModel.addAttribute("allProduct", allProduct);
		viewModel.addAttribute("notInProduct", notInProduct);
		return "category.jsp";
	}
	
	@PostMapping("/showCategory/addProductToCategory/{id}")
	public String addProductToCategory(@RequestParam("product")Long productId, @PathVariable("id")Long id) {
		Category thisCategory = this.pCService.getOneCategory(id);
		Product productToAdd = this.pCService.getOneProduct(productId);
		this.pCService.addProductToCategory(thisCategory, productToAdd);;
		return "redirect:/showCategory/{id}";
	}
	
}

package com.carrierinfo.carriercommerce.dao;

import java.util.List;

import com.carrierinfo.carriercommerce.model.Category;

public interface CategoryDao {
	
	void addCategory(Category category);
	Category findCategoryById(Long id);
	List<Category> getAllCategories();
	void updateCategory(Category category);
	void removeCategory(Category category);
	Category getCategoryByIdWithProducts(Long id);

}

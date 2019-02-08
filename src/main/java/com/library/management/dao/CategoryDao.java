package com.library.management.dao;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Categories;

public interface CategoryDao {
	public ApiResponse addCategory(Categories categories);
	public ApiResponse updateCategory(Categories categories);
	public ApiResponse deleteCategory(Integer categoryId);
	public ApiResponse getAllCategory();
}

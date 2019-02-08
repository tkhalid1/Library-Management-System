package com.library.management.services;

import com.library.management.common.ApiResponse;
import com.library.management.dao.CategoryDao;
import com.library.management.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

	@Autowired
	CategoryDao categoryDao;

	public ApiResponse addCategory(Categories categories){

		ApiResponse apiResponse = new ApiResponse();
		try{
			categoryDao.addCategory(categories);
			apiResponse.setStatusCode(200)
				.setMessage("successfully add category.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to add category.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse updateCategory(Categories categories){

		ApiResponse apiResponse = new ApiResponse();
		try{
			categoryDao.updateCategory(categories);
			apiResponse.setStatusCode(200)
				.setMessage("successfully update category.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to update category.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse deleteCategory(Integer categoryId){
		ApiResponse apiResponse = new ApiResponse();
		try{
			categoryDao.deleteCategory(categoryId);
			apiResponse.setStatusCode(200)
				.setMessage("successful delete category.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to delete category.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}

	}

	public ApiResponse getCategories(){
		ApiResponse apiResponse = new ApiResponse();
		try{
			return 	categoryDao.getAllCategory();
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to get all categories.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}

	}
}

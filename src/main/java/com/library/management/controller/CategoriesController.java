package com.library.management.controller;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Categories;
import com.library.management.services.CategoriesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/category")
public class CategoriesController {
	final static Logger logger = Logger.getLogger(CategoriesController.class);
	private CategoriesService categoriesService;

	@Autowired
	public CategoriesController setCategoriesService(CategoriesService categoriesService){
		this.categoriesService = categoriesService;
		return this;
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ApiResponse addCategory(@RequestBody Categories categories){

		return categoriesService.addCategory(categories);
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public ApiResponse updateCategory(@RequestBody Categories categories){

		return categoriesService.updateCategory(categories);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public ApiResponse deleteCategory(@RequestParam("categoryId") Integer categoryId){

		return categoriesService.deleteCategory(categoryId);
	}

	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ApiResponse getCategories(){

		return categoriesService.getCategories();
	}


}

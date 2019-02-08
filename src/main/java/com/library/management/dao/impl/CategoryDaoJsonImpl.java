package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.common.ApiResponse;
import com.library.management.dao.CategoryDao;
import com.library.management.entity.Categories;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoJsonImpl implements CategoryDao{
	final static Logger logger = Logger.getLogger(CategoryDaoJsonImpl.class);
	@Value("${json.file.path}")
	private String fileDirectory;

	@PostConstruct
	public void init(){
		fileDirectory = fileDirectory+"/category/";
		File file = new File(fileDirectory);
		if(file.exists() == false){
			file.mkdirs();
		}
	}
	@Override
	public ApiResponse addCategory(Categories categories) {
		try {
			Files.write(Paths.get(fileDirectory + categories.getId()+".json"), categories.toString().getBytes());
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
		return null;
	}

	@Override
	public ApiResponse updateCategory(Categories categories) {
		File deleteFile = new File(fileDirectory+categories.getId()+".json");
		deleteFile.delete();
		try {
			Files.write(Paths.get(fileDirectory + categories.getId()+".json"), categories.toString().getBytes());
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}

		return null;
	}

	@Override
	public ApiResponse deleteCategory(Integer categoryId) {
		File deleteFile = new File(fileDirectory+categoryId+".json");
		deleteFile.delete();
		return null;
	}

	@Override
	public ApiResponse getAllCategory() {
		File mainDirectory = new File(fileDirectory);
		if(!mainDirectory.exists()){
			return null;
		}

		List<Categories> list = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		for(File file :mainDirectory.listFiles()){
			try {
				Categories currentCategory = objectMapper.readValue(file, Categories.class);
				list.add(currentCategory);
			}catch(Exception ex){
				//TODO: Log here
				System.out.println(ex.getMessage());
			}
		}

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setSuccess("true").setMessage("SuccessFully fetched categories").setData(list);
		return apiResponse;
	}
}

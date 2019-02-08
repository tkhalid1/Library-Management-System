package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.library.management.common.ApiResponse;
import com.library.management.dao.CategoryDao;
import com.library.management.entity.Categories;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoYmlImpl implements CategoryDao{

	final static Logger logger = Logger.getLogger(CategoryDaoYmlImpl.class);
	@Value("${yml.file.path}")
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
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+categories.getId()+".yml"),categories);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ApiResponse updateCategory(Categories categories) {
		File deleteFile = new File(fileDirectory+categories.getId()+".yml");
		deleteFile.delete();
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+categories.getId()+".yml"),categories);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApiResponse deleteCategory(Integer categoryId) {
		File deleteFile = new File(fileDirectory+categoryId+".yml");
		deleteFile.delete();
		return null;
	}

	@Override
	public ApiResponse getAllCategory()
	{
		File mainDirectory = new File(fileDirectory);
		if(!mainDirectory.exists()){
			return null;
		}

		List<Categories> list = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
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

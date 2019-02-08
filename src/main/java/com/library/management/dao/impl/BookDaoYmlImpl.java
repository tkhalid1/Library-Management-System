package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.library.management.common.ApiResponse;
import com.library.management.dao.BookDao;
import com.library.management.entity.Books;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BookDaoYmlImpl implements BookDao{

	final static Logger logger = Logger.getLogger(BookDaoYmlImpl.class);
	@Value("${yml.file.path}")
	private String fileDirectory;

	@PostConstruct
	public void init(){
		fileDirectory = fileDirectory+"/book/";
		File file = new File(fileDirectory);
		if(file.exists() == false){
			file.mkdirs();
		}
	}
	@Override
	public ApiResponse addBook(Books books) {

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+books.getId()+".yml"),books);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApiResponse updateBook(Books books) {
		File deleteFile = new File(fileDirectory+books.getId()+".yml");
		deleteFile.delete();
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+books.getId()+".yml"),books);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApiResponse deleteBook(Integer bookId) {
		File deleteFile = new File(fileDirectory+bookId+".yml");
		deleteFile.delete();
		return null;
	}

	@Override
	public ApiResponse getAllBooks() {
		File mainDirectory = new File(fileDirectory);
		if(!mainDirectory.exists()){
			return null;
		}

		List<Books> list = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		for(File file :mainDirectory.listFiles()){
			try {
				Books currentBook = objectMapper.readValue(file, Books.class);
				list.add(currentBook);
			}catch(Exception ex){
				//TODO: Log here
				System.out.println(ex.getMessage());
			}
		}

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setSuccess("true").setMessage("SuccessFully fetched Books").setData(list);
		return apiResponse;
	}
}

package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.common.ApiResponse;
import com.library.management.dao.BookDao;
import com.library.management.entity.Books;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookDaoJsonImpl implements BookDao{

	final static Logger logger = Logger.getLogger(BookDaoJsonImpl.class);
	@Value("${json.file.path}")
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
		try {
			Files.write(Paths.get(fileDirectory + books.getId()+".json"), books.toString().getBytes());
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
		return null;
	}

	@Override
	public ApiResponse updateBook(Books books) {
		File deleteFile = new File(fileDirectory+books.getId()+".json");
		deleteFile.delete();
		try {
			Files.write(Paths.get(fileDirectory + books.getId()+".json"), books.toString().getBytes());
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return null;
	}

	@Override
	public ApiResponse deleteBook(Integer bookId) {
		File deleteFile = new File(fileDirectory+bookId+".json");
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
		ObjectMapper objectMapper = new ObjectMapper();
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
		apiResponse.setSuccess("true").setMessage("SuccessFully fetched books").setData(list);
		return apiResponse;

	}
}

package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.common.ApiResponse;
import com.library.management.dao.UserDao;
import com.library.management.entity.Users;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJsonImpl implements UserDao{
	final static Logger logger = Logger.getLogger(UserDaoJsonImpl.class);
	@Value("${json.file.path}")
	private String fileDirectory;

	@PostConstruct
	public void init(){
		fileDirectory = fileDirectory+"/user/";
		File file = new File(fileDirectory);
		if(file.exists() == false){
			file.mkdirs();
		}
	}

	@Override
	public ApiResponse addUser(Users users) {
		try {
			Files.write(Paths.get(fileDirectory + users.getId()+".json"), users.toString().getBytes());
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
		return null;
	}

	@Override
	public ApiResponse updateUser(Users users) {
		File deleteFile = new File(fileDirectory+users.getId()+".json");
		deleteFile.delete();
		try {
			Files.write(Paths.get(fileDirectory + users.getId()+".json"), users.toString().getBytes());
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}

		return null;
	}

	@Override
	public ApiResponse deleteUser(Integer userId) {

		File deleteFile = new File(fileDirectory+userId+".json");
		deleteFile.delete();
		return null;
	}

	@Override
	public ApiResponse getAllUser() {

		File mainDirectory = new File(fileDirectory);
		if(!mainDirectory.exists()){
			return null;
		}

		List<Users> list = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		for(File file :mainDirectory.listFiles()){
			try {
				Users currentUser = objectMapper.readValue(file, Users.class);
				list.add(currentUser);
			}catch(Exception ex){
				//TODO: Log here
				System.out.println(ex.getMessage());
			}
		}

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setSuccess("true").setMessage("SuccessFully fethed users").setData(list);
		return apiResponse;
	}
}

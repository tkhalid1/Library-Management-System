package com.library.management.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.library.management.common.ApiResponse;
import com.library.management.dao.UserDao;
import com.library.management.entity.Users;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoYmlImpl implements UserDao{
	final static Logger logger = Logger.getLogger(UserDaoYmlImpl.class);
	@Value("${yml.file.path}")
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

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+users.getId()+".yml"),users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApiResponse updateUser(Users users) {
		File deleteFile = new File(fileDirectory+users.getId()+".yml");
		deleteFile.delete();
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			mapper.writeValue(new File(fileDirectory+users.getId()+".yml"),users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApiResponse deleteUser(Integer userId) {
		File deleteFile = new File(fileDirectory+userId+".yml");
		deleteFile.delete();
		return null;
	}

	@Override
	public ApiResponse getAllUser()
	{
		File mainDirectory = new File(fileDirectory);
		if(!mainDirectory.exists()){
			return null;
		}

		List<Users> list = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
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
		apiResponse.setSuccess("true").setMessage("SuccessFully fetched users").setData(list);
		return apiResponse;
	}
}

package com.library.management.services;

import com.library.management.common.ApiResponse;
import com.library.management.dao.UserDao;
import com.library.management.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


	@Autowired
	private UserDao userDao;

	public ApiResponse addUser(Users users){

		ApiResponse apiResponse = new ApiResponse();
		try{
		userDao.addUser(users);
			apiResponse.setStatusCode(200)
				.setMessage("successful add user.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to add user.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse updateUser(Users users){

		ApiResponse apiResponse = new ApiResponse();
		try{
			userDao.updateUser(users);
			apiResponse.setStatusCode(200)
				.setMessage("successfully update user.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to update user.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse deleteUser(Integer userId){
		ApiResponse apiResponse = new ApiResponse();
		try{
			userDao.deleteUser(userId);
			apiResponse.setStatusCode(200)
				.setMessage("successful delete user.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to delete user.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}

	}

	public ApiResponse getUsers(){
		ApiResponse apiResponse = new ApiResponse();
		try{
			return 	userDao.getAllUser();

		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to get all users.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}

	}
}

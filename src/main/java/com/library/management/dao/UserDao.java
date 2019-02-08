package com.library.management.dao;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Users;

public interface UserDao {

	public ApiResponse addUser(Users users);
	public ApiResponse updateUser(Users users);
	public ApiResponse deleteUser(Integer userId);
	public ApiResponse getAllUser();


}

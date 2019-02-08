package com.library.management.controller;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Users;
import com.library.management.services.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UsersController {

	final static Logger logger = Logger.getLogger(UsersController.class);
private UsersService usersService;

@Autowired
	public UsersController setUsersService(UsersService usersService){
	this.usersService = usersService;
	return this;
}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ApiResponse addUser(@RequestBody Users users){

		return usersService.addUser(users);
}

@RequestMapping(value = "/update",method = RequestMethod.POST)
	public ApiResponse updateUser(@RequestBody Users users){

		return usersService.updateUser(users);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public ApiResponse deleteUser(@RequestParam("userId") Integer userId){

		return usersService.deleteUser(userId);
	}

	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ApiResponse getUsers(){

		return usersService.getUsers();
	}

}

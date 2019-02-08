package com.library.management.servicesTest;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Users;
import com.library.management.services.UsersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

	@Autowired
	UsersService usersService;
	@Test
	public void addCategory (){

		Users users = new Users();
		users.setId(1);
		users.setAddress("Islamabad");
		users.setCnic("42301-2804779-0");
		users.setMobile("0345-3682787");
		ApiResponse apiResponse = usersService.addUser(users);
		Assert.assertNotNull(apiResponse);
		Assert.assertEquals(apiResponse.getStatusCode().toString(),200);
	}
}

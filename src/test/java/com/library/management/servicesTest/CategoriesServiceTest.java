package com.library.management.servicesTest;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Categories;
import com.library.management.services.CategoriesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;
import org.junit.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriesServiceTest {

	@Autowired
	CategoriesService categoriesService;
	@Test
	public void addCategory (){

		Categories categories = new Categories();
		categories.setId(1);
		categories.setName("Computer Science");
		ApiResponse apiResponse = categoriesService.addCategory(categories);
		Assert.assertNotNull(apiResponse);
		Assert.assertEquals(apiResponse.getStatusCode().toString(),200);
	}
}

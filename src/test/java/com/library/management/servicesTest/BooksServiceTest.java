package com.library.management.servicesTest;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Books;
import com.library.management.services.BooksService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksServiceTest {

	@Autowired
	BooksService booksService;
	@Test
	public void addCategory (){

		Books books = new Books();
		books.setId(1);
		books.setAuthorName("Talha");
		books.setName("My Life");
		books.setCategoryId(1);
		ApiResponse apiResponse = booksService.addBook(books);
		Assert.assertNotNull(apiResponse);
		Assert.assertEquals(apiResponse.getStatusCode().toString(),200);
	}
}

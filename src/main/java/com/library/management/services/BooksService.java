package com.library.management.services;

import com.library.management.common.ApiResponse;
import com.library.management.dao.BookDao;
import com.library.management.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

	@Autowired
	BookDao bookDao;

	public ApiResponse addBook(Books books){

		ApiResponse apiResponse = new ApiResponse();
		try{
			bookDao.addBook(books);
			apiResponse.setStatusCode(200)
				.setMessage("successful add book.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to add book.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse updateBook(Books book){

		ApiResponse apiResponse = new ApiResponse();
		try{
			bookDao.updateBook(book);
			apiResponse.setStatusCode(200)
				.setMessage("successfully update book.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to update book.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse deleteBook(Integer bookId){
		ApiResponse apiResponse = new ApiResponse();
		try{
			bookDao.deleteBook(bookId);
			apiResponse.setStatusCode(200)
				.setMessage("successful delete book.")
				.setSuccess("True");
			return apiResponse;
		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to delete book.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}
	}

	public ApiResponse getBooks(){
		ApiResponse apiResponse = new ApiResponse();
		try{
			return 	bookDao.getAllBooks();


		}
		catch (Exception e){
			apiResponse.setStatusCode(500)
				.setMessage("Unable to get all books.")
				.setSuccess("False")
				.setError(e.toString());

			return apiResponse;

		}

	}
}

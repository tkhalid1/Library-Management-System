package com.library.management.dao;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Books;

public interface  BookDao {
	public ApiResponse addBook(Books books);
	public ApiResponse updateBook(Books books);
	public ApiResponse deleteBook(Integer bookId);
	public ApiResponse getAllBooks();
}

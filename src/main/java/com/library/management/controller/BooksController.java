package com.library.management.controller;

import com.library.management.common.ApiResponse;
import com.library.management.entity.Books;
import com.library.management.services.BooksService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/book")
public class BooksController {
	final static Logger logger = Logger.getLogger(BooksController.class);
	private BooksService booksService;

	@Autowired
	public BooksController setBooksService(BooksService booksService){
		this.booksService = booksService;
		return this;
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ApiResponse addBook(@RequestBody Books books){

		return booksService.addBook(books);
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public ApiResponse updateBook(Books books){

		return booksService.updateBook(books);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public ApiResponse deleteBook(@RequestParam("bookId") Integer bookId){

		return booksService.deleteBook(bookId);
	}

	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ApiResponse getBooks(){

		return booksService.getBooks();
	}
}

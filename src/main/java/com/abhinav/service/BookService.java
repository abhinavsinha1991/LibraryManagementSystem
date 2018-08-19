package com.abhinav.service;

import java.util.List;

import com.abhinav.models.Book;

/**
 * @author abhinav
 *
 */
public interface BookService {
	
	public void addBook(Book book);

	public String bookBook(int bookId);

	public Book getBook(Integer bookId);
	
	public Book updateBook(int BookId, Book book);

	public void deleteBook(Integer bookId);

	public List<Book> getAllBooks();
}

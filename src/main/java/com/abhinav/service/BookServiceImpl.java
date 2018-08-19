package com.abhinav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.models.Book;
import com.abhinav.repository.BookRepository;

/**
 * @author abhinav
 *
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public String bookBook(int bookId){
		Optional<Book> book=bookRepository.findById(bookId);

		if(book.get().getTotal_copies_booked()==book.get().getTotal_copies_available()){
			return "Sorry.All books booked!";
		}else{
			book.get().setTotal_copies_booked(book.get().getTotal_copies_booked()+1);
			bookRepository.save(book.get());
			return "Book successfully alloted";
		}
	}

	@Override
	public Book getBook(Integer bookId) {
		 return bookRepository.findById(bookId).get();
	}
	
	@Override
	public Book updateBook(int bookId, Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books=new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

}

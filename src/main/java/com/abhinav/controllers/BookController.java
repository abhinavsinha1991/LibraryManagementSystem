package com.abhinav.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abhinav.models.Book;
import com.abhinav.service.BookService;

/**
 * @author abhinav
 *
 */
@Controller
public class BookController {
	
	public static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list_books" , method = RequestMethod.GET)
	public ModelAndView ListBooks(ModelAndView model) throws IOException {
		List<Book> listBooks = bookService.getAllBooks();
		model.addObject("listBooks", listBooks);
		model.setViewName("books");
		
		return model;
	}
	
	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public ModelAndView newBook(ModelAndView model) {
		Book book = new Book();
		model.addObject("book", book);
		model.setViewName("addBook");
		
		return model;
	}
	
	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {

		ModelAndView model=new ModelAndView("books");
		if (book.getISBN()==0) {
			if(!(book.getTotal_copies_booked()>book.getTotal_copies_available()))
				bookService.addBook(book);
			else
				model.addObject("msg","No. of books alloted cannot be more than available.Try again!");
		} else {
			if(!(book.getTotal_copies_booked()>book.getTotal_copies_available()))
				bookService.updateBook(book.getISBN() , book);
			else
				model.addObject("msg","No. of books alloted cannot be more than available.Try again!");
		}
		model.addObject("listBooks",bookService.getAllBooks());
		return model;
		//return new ModelAndView("redirect:/list_books");
	}
	
	@RequestMapping(value = "/edit_book", method = RequestMethod.GET)
	public ModelAndView updateBook(HttpServletRequest request) {
		Integer bookId= Integer.valueOf(request.getParameter("isbn"));
		Book book=bookService.getBook(bookId);
		ModelAndView model = new ModelAndView("addBook");
		model.addObject("book",book);
		
		return model;
	}
	
	@RequestMapping(value = "/delete_book", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		Integer bookId= Integer.valueOf(request.getParameter("isbn"));
		bookService.deleteBook(bookId);
		return new ModelAndView("redirect:/list_books");
	}

	@RequestMapping(value="/allot_book" , method = RequestMethod.GET)
	public ModelAndView allotBook(ModelAndView model) throws IOException {
		List<Book> listBooks = bookService.getAllBooks();
		model.addObject("listBooks", listBooks);
		model.setViewName("allotBook");

		return model;
	}

	@RequestMapping(value = "/book_book", method = RequestMethod.GET)
	public ModelAndView bookBook(HttpServletRequest request) {
		Integer bookId= Integer.valueOf(request.getParameter("isbn"));

		String message=bookService.bookBook(bookId);
		List<Book> bookList=bookService.getAllBooks();
		ModelAndView model=new ModelAndView("allotBook");
		model.addObject("listBooks",bookList);
		model.addObject("msg",message);
		return model;
	}
}

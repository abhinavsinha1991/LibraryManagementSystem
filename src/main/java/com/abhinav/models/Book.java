package com.abhinav.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author abhinav
 *
 */
@Entity
public class Book implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "BOOK_GEN", allocationSize = 1)
	@Id
	private int ISBN;

	private String book_name;
	private String publish_year;
	private String publisher;

	private String author;
	private int total_copies_available;
	private int total_copies_booked;

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(String publish_year) {
		this.publish_year = publish_year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getTotal_copies_available() {
		return total_copies_available;
	}

	public void setTotal_copies_available(int total_copies_available) {
		this.total_copies_available = total_copies_available;
	}

	public int getTotal_copies_booked() {
		return total_copies_booked;
	}

	public void setTotal_copies_booked(int total_copies_booked) {
		this.total_copies_booked = total_copies_booked;
	}

}


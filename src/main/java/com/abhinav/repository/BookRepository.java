package com.abhinav.repository;

import org.springframework.data.repository.CrudRepository;

import com.abhinav.models.Book;

/**
 * @author abhinav
 *
 */
public interface BookRepository extends CrudRepository<Book, Integer>{

}

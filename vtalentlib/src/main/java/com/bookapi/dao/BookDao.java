package com.bookapi.dao;

import java.util.List;

import com.bookapi.model.Book;

public interface BookDao {
	long save(Book book);
	Book getSingleRecord(long id);
   List<Book> getAllBooks();
   boolean updateBook(long id, Book book);
   boolean deleteBook(long id);
	

}

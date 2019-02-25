package com.bookapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapi.dao.BookDao;
import com.bookapi.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public long save(Book book) {
		
		return bookDao.save(book);
	}

	@Override
	@Transactional
	public Book getSingleRecord(long id) {
		
		return bookDao.getSingleRecord(id);
	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		
		
		return bookDao.getAllBooks();
	}

	@Override
	@Transactional
	public boolean updateBook(long id, Book book) {
		bookDao.updateBook(id, book);
		return false;
	}

	@Override
	@Transactional
	public boolean deleteBook(long id) {
		bookDao.deleteBook(id);
		return false;
	}

}

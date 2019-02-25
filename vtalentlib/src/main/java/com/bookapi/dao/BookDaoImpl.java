package com.bookapi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapi.model.Book;
@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book getSingleRecord(long id) {
		
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	
	public List<Book> getAllBooks() {
	     List<Book> list=sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	@Override
	public boolean updateBook(long id, Book book) {
		Session session=sessionFactory.getCurrentSession();
		Book oldBook=session.byId(Book.class ).load(id);
		oldBook.setBookName(book.getBookName());
		oldBook.setBookAuthor(book.getBookAuthor());
		session.flush();
		return false;
	}

	@Override
	public boolean deleteBook(long id) {
		Session session=sessionFactory.getCurrentSession();
		Book book=session.byId(Book.class).load(id);
		session.delete(book);
		return false;
	}

}

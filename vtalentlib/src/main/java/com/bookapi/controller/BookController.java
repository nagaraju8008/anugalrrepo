package com.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.model.Book;
import com.bookapi.service.BookService;
@CrossOrigin("*")
@RestController
public class BookController {
@Autowired 
private BookService bookService;

//getting all the books in the database
@GetMapping("/api/book")
public ResponseEntity<List<Book>> list(){
List<Book>list=	bookService.getAllBooks();
return ResponseEntity.ok().body(list);
	
}



//save the book  
@PostMapping("/api/book")
public ResponseEntity<?>save(@RequestBody Book book){
	long id=bookService.save(book);
	return ResponseEntity.ok().body("book is created with id--"+id);
}


// getting single record
@GetMapping("/api/book/{id}")
public ResponseEntity<Book> get(@PathVariable("") long id){
	Book book=bookService.getSingleRecord(id);
	return ResponseEntity.ok().body(book);
	
}
// update the book record
@PutMapping("/api/book/{id}")
public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody Book book){
	bookService.updateBook(id, book);
	return ResponseEntity.ok().body("book has been updated successsfully");
	
}


// deleting a book record
@DeleteMapping("/api/book/{id}")
public ResponseEntity<?>delete(@PathVariable("id") long id){
	bookService.deleteBook(id);
	return ResponseEntity.ok().body("book has been deleted");
	
}



}

package com.codingdojo.project.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.project.modelos.Book;
import com.codingdojo.project.repositorios.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository repository;
	
	
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Book save(Book book) {
		return repository.save(book);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}


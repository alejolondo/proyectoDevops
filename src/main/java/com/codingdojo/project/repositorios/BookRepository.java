package com.codingdojo.project.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.modelos.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}

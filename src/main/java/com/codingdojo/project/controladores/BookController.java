package com.codingdojo.project.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.project.modelos.Book;
import com.codingdojo.project.modelos.User;
import com.codingdojo.project.servicios.BookService;

@Controller
public class BookController {

	
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		
		model.addAttribute("books", service.findAll());

		User currentUser = (User)session.getAttribute("userSession");
		if(currentUser == null) {
			return "redirect:/";
		}
		return "books.jsp";
	}
	
	@GetMapping("/saveBook")
	public String bookForm(@ModelAttribute("book")Book book, HttpSession session ) {
		
		User currentUser = (User)session.getAttribute("userSession");
		if(currentUser == null) {
			return "redirect:/";
		}
		return "newBook.jsp";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@Valid @ModelAttribute("book")Book book,
									BindingResult result, Model model,
		
									HttpSession session) {
		
		
		User currentUser = (User)session.getAttribute("userSession");
		book.setUser(currentUser);
		service.save(book);
		
		return "redirect:/books";
		
	}
	
	
	@GetMapping("book/{id}")
	public String bookDetails(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		model.addAttribute("book",	service.findById(id));
		
		
		User currentUser = (User)session.getAttribute("userSession");
		if(currentUser == null) {
			return "redirect:/";
		}
		return "bookInfo.jsp";
	}
	
	@GetMapping("/book/edit/{id}")
	public String editBook(@PathVariable("id")Long id,  @ModelAttribute("book")Book book, Model model) {
		
		model.addAttribute("book", service.findById(id));
		return "editBook.jsp";
	}
	
	
	@PutMapping("/book/edit/{id}")
	public String saveEdit(@Valid @ModelAttribute("book")Book book, BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			User currentUser = (User)session.getAttribute("userSession");
			book.setUser(currentUser);
			service.save(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("book/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		service.delete(id);
		
		return "redirect:/books";
		
	}
	
	
	
	
}

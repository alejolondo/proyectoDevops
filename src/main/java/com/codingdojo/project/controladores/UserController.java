package com.codingdojo.project.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.project.modelos.LoginUser;
import com.codingdojo.project.modelos.User;
import com.codingdojo.project.servicios.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario")User nuevoUsuario,
						@ModelAttribute("nuevoLogin")LoginUser nuevoLogin) {
		return "index.jsp";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("nuevoUsuario") User nuevoUsuario, BindingResult result,
							Model model, HttpSession session) {
		
		service.register(nuevoUsuario, result);
		
		if (result.hasErrors()) {
			model.addAttribute("nuevoLogin", new LoginUser());
			return "index.jsp";
		}else {
			session.setAttribute("userSession", nuevoUsuario);
			return "redirect:/books";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("nuevoLogin")LoginUser nuevoLogin, 
						BindingResult result, Model model, HttpSession session) {
		
		User user = service.login(nuevoLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("nuevoUsuario", new User());
			return "index.jsp";
		}else {
			session.setAttribute("userSession", user);
			return "redirect:/books";
		}
	}
}

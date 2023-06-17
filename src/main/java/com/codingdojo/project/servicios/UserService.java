package com.codingdojo.project.servicios;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.project.modelos.LoginUser;
import com.codingdojo.project.modelos.User;
import com.codingdojo.project.repositorios.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User register(User nuevoUsuario, BindingResult result) {
		
		if(!nuevoUsuario.getPassword().equals(nuevoUsuario.getConfirm())) {
			result.rejectValue("password", "Matches", "La contraseña no coincide");
		}
		
		String nuevoEmail = nuevoUsuario.getEmail();
		if(repository.findByEmail(nuevoEmail).isPresent()){
			result.rejectValue("email", "Unique", "El email ingresado ya fue registrado");
		}
		
		if(result.hasErrors()) {
			return null;
		}else {
			String passwordEncriptada = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordEncriptada);
			
			return repository.save(nuevoUsuario);
		}
		
	}
	
	public User login(LoginUser nuevoLogin, BindingResult result) {
		
		Optional<User> posibleUsuario = repository.findByEmail(nuevoLogin.getEmail());
		
		if(!posibleUsuario.isPresent()) {
			result.rejectValue("email", "Unique", "Email no registrado");
			return null;
		}
		
		User userLogin = posibleUsuario.get();
		if(!BCrypt.checkpw(nuevoLogin.getPassword(), userLogin.getPassword())) {
			result.rejectValue("password", "Matches", "Contraseña inválida");
		}
		
		if(result.hasErrors()) {
			return null;
		}else {
			return userLogin;
		}
	}
}

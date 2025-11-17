package com.trindade.digital_wallet.controllers;

import com.trindade.digital_wallet.domain.User;
import com.trindade.digital_wallet.dtos.UserDTO;
import com.trindade.digital_wallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador responsável por gerenciar endpoints relacionados ao usuário.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	// Cria um novo usuário
	@PostMapping
	public ResponseEntity<User> createUser(UserDTO user) {
		User newU = this.service.createUser(user);

		return new ResponseEntity<>(newU, HttpStatus.CREATED);
	}

	// Recupera todos os usuários
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = this.service.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}

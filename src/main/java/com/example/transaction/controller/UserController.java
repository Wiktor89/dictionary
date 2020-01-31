package com.example.transaction.controller;

import java.util.List;

import com.example.transaction.model.User;
import com.example.transaction.service.ServiceCRUD;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

	private final ServiceCRUD userService;

	@GetMapping(value = "/")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping(value = "/create")
	public void add(@RequestBody User user) {
		userService.save(user);
	}
}

package com.ashwin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.accessingdatamysql.User;
import com.ashwin.accessingdatamysql.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/user")
	public List<User> getUsers(){
		return (List<User>)userRepository.findAll();
	}
	@GetMapping("/api/user/{id}")
	public Optional<User> getUser(@PathVariable int id){
		return userRepository.findById(id);
	}
	@PostMapping("/api/user")
	public void addNewUser(@PathVariable User user) {
		userRepository.save(user);
	}
	@GetMapping("/api/user/del/{id}")
	public String delUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "Successfully Deleted" +id;
	}

}

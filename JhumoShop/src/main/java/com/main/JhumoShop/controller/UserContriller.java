package com.main.JhumoShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.JhumoShop.midelData.User;
import com.main.JhumoShop.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="users")
public class UserContriller {
	@Autowired
	private  UserRepository userRepo;
	
	@GetMapping("/get")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		userRepo.save(user);
	}
	//Bow create delete method to delete the record by id
	@DeleteMapping(path={"/id"})
	public User deleteUser(@PathVariable("id") Long id){
		User user=userRepo.getOne(id);
		userRepo.deleteById(id);
		return user;
		
	}
	

}

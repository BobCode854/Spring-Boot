package com.spring.RestfulWebServices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserController {
	@Autowired
	UserDao dao;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return dao.findAll();
	}

	@GetMapping("/users/{id}")
	public User getAllUser(@Valid @PathVariable int id) {
		// getting the user from db
		User user = dao.findOne(id);
		// if user does not exist in the db
		if (user == null)
			throw new UserNotFoundException("id : " + id);

		// if user exist in db then
		return user;

	}

	@PostMapping("/users")
	public ResponseEntity<Object> getAllUser(@RequestBody User user) {
		User savedUser = dao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

// here fromCurrentRequest =default path i.e localhost:8080/users 
//path require what you need to add . So we need to add ---->id which will be dynamic
// build and expand expect the dynamic property value which we will be able to get
// with---------------> savedUser.getId().

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteByUserId(@PathVariable int id) {
		// getting the user from db
		User user = dao.deleteUserById(id);
		// if user does not exist in the db
		if (user == null)
			throw new UserNotFoundException("id : " + id);

	}
	
}

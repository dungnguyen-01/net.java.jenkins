package net.java.jenkins.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.jenkins.entity.User;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	
	@GetMapping()
	public ResponseEntity<List<User>> all() {
		List<User> users = new ArrayList<>();
		
		users.add(new User("Nguyen Van A", 23));	
		users.add(new User("Nguyen Van B", 21));
		users.add(new User("Nguyen Van C", 20));	
		users.add(new User("Nguyen Van D", 29));
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}





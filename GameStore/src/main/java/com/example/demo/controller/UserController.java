package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService ;

	
	public UserController(UserService userService) {
		//super();
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "page", defaultValue = "0") int pageIndex,
			@RequestParam(value = "size", defaultValue = "10") int pageSize)
	{
		Pageable pageable = PageRequest.of(pageIndex, pageSize);
		List<User> users=userService.findAllUsers(pageable);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
	{
		User user=userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@PostMapping
	public String addUser(@RequestBody @Valid UserDto userDto)
	{
		//User newuser =userService.addUser(userDto);
		//return ResponseEntity.status(HttpStatus.CREATED).header("X_ID",userService.addUser(userDto).toString()).build();
		return userService.addUser(userDto).toString();
		//return new ResponseEntity<>(,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id)
	{
		User newUser = userService.updatUser(user);
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
	}
	
}

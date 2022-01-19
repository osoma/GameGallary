package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.Mapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	private final UserMapper userMapper;


	@Autowired
	public UserService(UserRepo userRepo,UserMapper userMapper) {
		//super();
		this.userRepo = userRepo;
		this.userMapper=userMapper;
	}
	
	public Long addUser( UserDto userDto)
	{
		User user =userMapper.toEntity(userDto);
		user.setUserCode(UUID.randomUUID().toString());
		return userRepo.save(user).getUserId(); 
	}
	
	public List<User> findAllUsers(Pageable pageable)
	{
		return userRepo.findAll(pageable).toList();
	}
	
	public User updatUser(User user)
	{
		return userRepo.save(user);
	
	}
	public void deleteUser(Long id)
	{
		userRepo.deleteById(id);
	}
	
	public User findUserById(Long id)
	{
		return userRepo.findById(id).orElseThrow( ()-> new NotFoundException("user "+id +" was not Found...") );
	}

}

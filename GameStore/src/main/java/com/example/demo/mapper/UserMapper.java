package com.example.demo.mapper;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import lombok.Data;

@Service
public class UserMapper implements Mapper<UserDto, User> {

	@Override
	public UserDto toDto(User entity) {
		// TODO Auto-generated method stub

		UserDto userDto = new UserDto();
		userDto.setUserName(entity.getUserName());
		userDto.setAddress(entity.getAddress());
		userDto.setEmail(entity.getEmail());
		userDto.setPhone(entity.getPhone());
		userDto.setUserId(entity.getUserId());
		userDto.setUserCode(entity.getUserCode());
		return userDto;
	}

	@Override
	public User toEntity(UserDto dto) {

		// TODO Auto-generated method stub

		User user = new User();
		user.setUserName(dto.getUserName());
		user.setAddress(dto.getAddress());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		return user;
	}

	@Override
	public User updateEntity(UserDto dto, User user) {

		user.setUserName(dto.getUserName());
		user.setAddress(dto.getAddress());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		return user;

	}

}

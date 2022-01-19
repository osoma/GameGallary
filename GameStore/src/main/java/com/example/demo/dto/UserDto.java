package com.example.demo.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UserDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private long userId;
	@NotEmpty  
	@Size(min = 4,max = 10)
	private String userName;
	@Email
	private String email;
	@NotEmpty
	private String address;
	@NotEmpty
	private String phone;
	@JsonProperty(access = Access.READ_ONLY)
	private String userCode;
}

package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.Data;
@Data
public class GameDto {

	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	@NotEmpty
	private String name;
	private String details;
	@NotNull
	@Min(value= 0)
	private Double price;
	private String gameCode;
}

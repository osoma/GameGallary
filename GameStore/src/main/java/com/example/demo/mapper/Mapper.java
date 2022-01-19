package com.example.demo.mapper;

public interface Mapper <D,E>{
	public D toDto(E entity);
	public E toEntity(D dto);
	public E updateEntity(D dto, E entity);

}

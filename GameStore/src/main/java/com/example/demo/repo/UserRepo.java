package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	//void deleteUserById(long id);
	//Optional<User> findUserById(long id);
}

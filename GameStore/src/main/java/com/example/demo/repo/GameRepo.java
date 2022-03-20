package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Game;

public interface GameRepo extends JpaRepository<Game, Long> {

	//void deleteGameById(long id);
	//Optional<Game> findGameById(long id);
	Optional<Game> findByNameIgnoreCase(String name);
	
}

package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Game;
import com.example.demo.repo.GameRepo;

@Service
public class GameService {

	private final GameRepo gameRepo;

	@Autowired
	public GameService(GameRepo gameRepo) {
		//super();
		this.gameRepo = gameRepo;
	}
	
	public Game addGame(Game game)
	{
		game.setGameCode(UUID.randomUUID().toString());
		return gameRepo.save(game);
	}
	
	public List<Game> findAllGames (Pageable pageable)
	{
		return gameRepo.findAll(pageable).toList();
	}
	public void deleteGameById(long id)
	{
		gameRepo.deleteById(id);
	}
	public Game findGameById(long id)
	{
		return gameRepo.findById(id).orElseThrow( ()-> new NotFoundException("This Game "+id +" was not found") );
	}
	public Game updateGame(Game game)
	{
		return gameRepo.save(game);
	}
	
	
}

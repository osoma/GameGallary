package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;
import com.example.demo.exception.ConficlitException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.GameMapper;
import com.example.demo.mapper.Mapper;
import com.example.demo.repo.GameRepo;

@Service
public class GameService {

	private final GameRepo gameRepo;
	private final GameMapper gameMapper;

	@Autowired
	public GameService(GameRepo gameRepo,GameMapper mapper) {
		//super();
		this.gameRepo = gameRepo;
		this.gameMapper=mapper;
	}
	
	public Boolean gameExist(String name)
	{
		//get game with name;
		Optional<Game> tempGame=gameRepo.findByNameIgnoreCase(name);
		
		//check if it returns null or not
		return tempGame.isPresent();
		//if null -> return True; 
			
	}
	public Game addGame(GameDto gamedto)
	{
		gamedto.setGameCode(UUID.randomUUID().toString());
		//
		if(gameExist(gamedto.getName()))
		{
			throw new ConficlitException("GAME ALRADY CREATED");
		}
		return gameRepo.save(gameMapper.toEntity(gamedto));
	}
	
	public List<Game> findAllGames (Pageable pageable)
	{
		return gameRepo.findAll(pageable).toList();
	}
	public void deleteGameById(long id)
	{
		gameRepo.deleteById(id);
	}
	public Game findGameById(long id) //throws NotFoundException
	{
		return gameRepo.findById(id).orElseThrow(()->new NotFoundException("game Not found"));//.orElseThrow( ()-> new NotFoundException("This Game "+id +" was not found") );
	}
	public Game updateGame(GameDto gameDto)
	{
		//get Entity by id
		//Update game 
		//
		Game tempGame=findGameById(gameDto.getId());
		
		Game newGame=gameMapper.updateEntity(gameDto, tempGame);
		
		return gameRepo.save(newGame);
	}
	
	
}

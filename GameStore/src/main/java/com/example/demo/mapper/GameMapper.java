package com.example.demo.mapper;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;

@Service
public class GameMapper implements Mapper<GameDto, Game> {

	@Override
	public GameDto toDto(Game entity) {
		
		GameDto gameDto = new GameDto();
		gameDto.setName(entity.getName());
		gameDto.setId(entity.getId());
		gameDto.setPrice(entity.getPrice());
		gameDto.setDetails(entity.getDetails());
		gameDto.setGameCode(entity.getGameCode());
		return gameDto;
		
		
	}

	@Override
	public Game toEntity(GameDto dto) {

		Game game=new Game();
	
		game.setName(dto.getName());
		game.setId(dto.getId());
		game.setPrice(dto.getPrice());
		game.setDetails(dto.getDetails());
		game.setGameCode(dto.getGameCode());
		return game;
		
	}

	@Override
	public Game updateEntity(GameDto dto, Game game) {

		
		game.setName(dto.getName());
		game.setPrice(dto.getPrice());
		game.setDetails(dto.getDetails());
		game.setGameCode(dto.getGameCode());
		return game;
	}
	

}

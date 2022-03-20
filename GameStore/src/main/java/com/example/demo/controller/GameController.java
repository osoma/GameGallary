package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;
import com.example.demo.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	private final GameService gameService;

	public GameController(GameService gameService) {
		//super();
		this.gameService = gameService;
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> getAllGames(@RequestParam(value="page",defaultValue = "0") int pageIndex ,
			@RequestParam(value ="size" ,defaultValue = "1") int pageSize)
	{
		Pageable pageable= PageRequest.of(pageIndex, pageSize);
		List<Game> games=gameService.findAllGames(pageable);
		return new ResponseEntity<>(games,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addGame(@RequestBody @Valid GameDto gameDto)
	{

		return ResponseEntity.status(HttpStatus.CREATED).header("ID",gameService.addGame(gameDto).getId().toString()).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Game> findGameById(@PathVariable Long id ) //throws NotFoundException
	{
		Game newgame=gameService.findGameById(id);
		
		return new ResponseEntity<Game>(newgame,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateGame (@RequestBody GameDto gameDto)
	{
		//Game newGAme= gameService.findGameById();
		gameService.updateGame(gameDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id)
	{
		
		gameService.deleteGameById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}

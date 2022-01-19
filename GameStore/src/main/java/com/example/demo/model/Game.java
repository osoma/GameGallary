package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameId;
	private String gameName;
	private String details;
	private double price;
	@Column(nullable = false,updatable = false)
	private String gameCode;
	
	public Game() {
		super();
	}
	public Game(long gameId, String gameName, String details, double price, String gameCode) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.details = details;
		this.price = price;
		this.gameCode = gameCode;
	}

	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGameCode() {
		return gameCode;
	}
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	
}

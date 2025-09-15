package com.pl.premier_zone.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class PlayerService {
	//component - spring will create the object of this class and manage its lifecycle

	private final PlayerRepository playerRepository;
	
	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		//Autowired is used - inject this player repository bean into service which will
		//enable to interact with database
		this.playerRepository = playerRepository;
	}
	
	public List<Player> getPlayers(){
		return playerRepository.findAll();
	}
	
	public List<Player> getPlayersFromTeam(String teamName){
		return playerRepository.findAll().stream()
				.filter(player -> teamName.equals(player.getTeamName()))
				.collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByName(String searchText){
		return playerRepository.findAll().stream()
				.filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByPosition(String positionName){
		return playerRepository.findAll().stream()
				.filter(player -> player.getPos().toLowerCase().contains(positionName.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByNation(String nationName){
		return playerRepository.findAll().stream()
				.filter(player -> player.getNation().toLowerCase().contains(nationName.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByTeamandPosition(String team,String position){
		return playerRepository.findAll().stream()
				.filter(player -> team.equals(player.getTeamName()) && position.equals(player.getPos()))
				.collect(Collectors.toList());
	}
	
	public Player addPlayer(Player player) {
		playerRepository.save(player);
		return player;
	}
	
	public Player updatePlayer(Player updatedPlayer) {
		Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
		if(existingPlayer.isPresent()) {
			Player playerToUpdate = existingPlayer.get();
			playerToUpdate.setName(updatedPlayer.getName());
			playerToUpdate.setTeamName(updatedPlayer.getTeamName());
			playerToUpdate.setPos(updatedPlayer.getPos());
			playerToUpdate.setNation(updatedPlayer.getNation());
			playerRepository.save(playerToUpdate);
			return playerToUpdate;
		}
		return null;
	}
	
	@Transactional
	public void deletePlayer(String playerName) {
		playerRepository.deleteByname(playerName);
	}
}

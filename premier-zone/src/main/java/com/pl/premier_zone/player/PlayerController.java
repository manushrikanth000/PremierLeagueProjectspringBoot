package com.pl.premier_zone.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
//marks the class as a spring MVC controller
//where every method return domain object instead of views

private final PlayerService playerService;

@Autowired//allows controller to delegate the logic to business layer
public PlayerController(PlayerService playerService) {
	this.playerService = playerService;
}

@GetMapping
public List<Player> getPlayers(
		@RequestParam(required = false) String team,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String position,
		@RequestParam(required = false) String nation){
	if(team !=null && position!=null) {
		return playerService.getPlayersByTeamandPosition(team, position);
	}else if(team !=null) {
		return playerService.getPlayersFromTeam(team);
	}else if(name != null) {
		return playerService.getPlayersByName(name);
	}else if(position != null) {
		return playerService.getPlayersByPosition(position);
	}
	return playerService.getPlayers();
}

@PostMapping
public ResponseEntity<Player> add(@RequestBody Player player){
	Player createdPlayer = playerService.addPlayer(player);
	return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
}

@PutMapping
public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
	Player resultPlayer = playerService.updatePlayer(player);
	if(resultPlayer!=null) {
		return new ResponseEntity<Player>(resultPlayer,HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/playerName")
public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
	playerService.deletePlayer(playerName);
	return new ResponseEntity<>("Player deleted successfully",HttpStatus.OK);
}

}

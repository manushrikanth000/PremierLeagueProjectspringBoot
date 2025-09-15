package com.pl.premier_zone.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String>{
	//entity type = player, table id(our case)= string

	void deleteByname(String playerName);
	
	Optional<Player> findByName(String name);//optional is used when object is not there
	
}

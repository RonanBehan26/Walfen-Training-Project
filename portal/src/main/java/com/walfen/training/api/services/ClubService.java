package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Player;

public interface ClubService {

	List<Club> list();

	Club get(Long id);

	List<Player> listPlayers(Long id);
	
}

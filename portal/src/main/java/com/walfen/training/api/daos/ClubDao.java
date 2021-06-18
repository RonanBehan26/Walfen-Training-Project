package com.walfen.training.api.daos;

import java.util.List;
import java.util.Optional;

import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Player;

public interface ClubDao {

	List<Club> findAll();

	Optional<Club> findById(Long id);

	List<Player> findPlayersById(Long id);

}

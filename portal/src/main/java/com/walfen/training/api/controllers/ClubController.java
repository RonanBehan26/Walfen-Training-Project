package com.walfen.training.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.AnimalDto;
import com.walfen.training.api.dtos.ClubDto;
import com.walfen.training.api.dtos.PlayerDto;
import com.walfen.training.api.dtos.ZooDto;
import com.walfen.training.api.entities.Club;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.services.ClubService;

@RestController
@RequestMapping("/clubs")
public class ClubController {

	@Resource
	private ClubService clubService;

	@Resource
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDto> list() {

		// what the response should be
		List<Club> clubs = clubService.list();

		return clubs.stream().map(a -> mapper.map(a, ClubDto.class)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClubDto get(@PathVariable Long id) {
		Club club = clubService.get(id);

		return mapper.map(club, ClubDto.class);
	}

	@RequestMapping(value = "/{id}/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public List<PlayerDto> getPlayers(@PathVariable Long id) {

		List<PlayerDto> players = clubService.listPlayers(id);

		return players.stream().map(a -> mapper.map(a, PlayerDto.class)).collect(Collectors.toList());
	}

}

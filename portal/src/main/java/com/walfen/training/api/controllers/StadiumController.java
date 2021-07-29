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

import com.walfen.training.api.dtos.ClubDto;
import com.walfen.training.api.dtos.StadiumDto;
import com.walfen.training.api.entities.Club;
import com.walfen.training.api.entities.Stadium;
import com.walfen.training.api.services.StadiumService;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

	@Resource
	private StadiumService stadiumService;

	@Resource
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StadiumDto> list() {

		// what the response should be
		List<Stadium> stadiums = stadiumService.list();

		return stadiums.stream().map(a -> mapper.map(a, StadiumDto.class)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public StadiumDto get(@PathVariable Long id) {
		Stadium stadium = stadiumService.get(id);

		return mapper.map(stadium, StadiumDto.class);
	}

}

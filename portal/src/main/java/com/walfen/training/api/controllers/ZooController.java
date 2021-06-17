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

import com.walfen.training.api.dtos.AddressDto;
import com.walfen.training.api.dtos.AnimalDto;
import com.walfen.training.api.dtos.ZooDto;
import com.walfen.training.api.entities.Address;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.services.ZooService;
import com.walfen.training.api.zoo.Animal;

@RestController
@RequestMapping("/zoos")
public class ZooController {

	@Resource
	private ZooService zooService;

	@Resource
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ZooDto> list() {

		// what the response should be
		List<Zoo> zoos = zooService.list();

		return zoos.stream().map(a -> mapper.map(a, ZooDto.class)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ZooDto get(@PathVariable Long id) {
		Zoo zoo = zooService.get(id);

		return mapper.map(zoo, ZooDto.class);
	}

	@RequestMapping(value = "/{id}/animals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	// the request mapping var needs to be the same as in @PathVariable
	// getAnimals is the header
	public List<AnimalDto> getAnimals(@PathVariable Long id) {

		List<AnimalDto> animals = zooService.listAnimals(id);

		return animals.stream().map(a -> mapper.map(a, AnimalDto.class)).collect(Collectors.toList());
	}

}

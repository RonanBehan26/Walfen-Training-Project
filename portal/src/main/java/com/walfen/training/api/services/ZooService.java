package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.dtos.AnimalDto;
import com.walfen.training.api.entities.Zoo;

public interface ZooService {

	List<Zoo> list();
	
	Zoo get(Long id);

	List<AnimalDto> listAnimals(Long id);

}

package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.zoo.Animal;

public interface ZooService {

	List<Zoo> list();
	
	Zoo get(Long id);

	Zoo get(List<Animal> animals);

}

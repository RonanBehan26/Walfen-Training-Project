package com.walfen.training.api.daos;

import java.util.List;
import java.util.Optional;

import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.zoo.Animal;

public interface ZooDao  {

	List<Zoo> findAll();

	Optional<Zoo> findById(Long id);
	
	List<Animal> findAnimalsById(Long id);



}

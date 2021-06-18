package com.walfen.training.api.daos;

import java.util.List;
import java.util.Optional;

import com.walfen.training.api.entities.Stadium;

public interface StadiumDao {

	List<Stadium> findAll();

	Optional<Stadium> findById(Long id);
	
}

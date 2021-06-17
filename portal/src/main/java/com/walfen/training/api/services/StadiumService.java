package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Stadium;

public interface StadiumService {
	
	List<Stadium> list();

	Stadium get(Long id);

}

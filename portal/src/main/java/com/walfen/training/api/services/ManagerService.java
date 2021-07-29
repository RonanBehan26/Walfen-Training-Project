package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.Manager;

public interface ManagerService {

	List<Manager> list();
	
	Manager get(Long id);
	
	Manager create(Manager manager);
	
	Manager update(Manager manager);

	void delete(Long id);

	
	}



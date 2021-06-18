
package com.walfen.training.api.services.impl;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.ZooDao;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.services.ZooService;
import com.walfen.training.api.zoo.Animal;


@Service
public class ZooServiceImpl implements ZooService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZooServiceImpl.class);

	@Resource
	private ZooDao zooDao;

	@Override
	public List<Zoo> list() {
		LOGGER.info("list zoos");
		return zooDao.findAll();
	}
	
	@Override
	public Zoo get(Long id) {
		LOGGER.info("get zoo - id: {}", id);
		return zooDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@Override
	public List<Animal> listAnimals(Long id) {
		LOGGER.info("get animals - id: {}", id);
		return zooDao.findAnimalsById(id);
	}

}

package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.StadiumDao;
import com.walfen.training.api.entities.Stadium;
import com.walfen.training.api.services.StadiumService;

@Service
public class StadiumServiceImpl implements StadiumService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StadiumServiceImpl.class);
	
	@Resource
	private StadiumDao stadiumDao;

	@Override
	public List<Stadium> list() {
		LOGGER.info("list stadiums");
		return stadiumDao.findAll();
	}

	@Override
	public Stadium get(Long id) {
		LOGGER.info("get stadium - id: {}", id);
		return stadiumDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}

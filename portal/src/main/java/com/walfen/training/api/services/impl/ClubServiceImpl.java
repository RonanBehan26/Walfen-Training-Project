package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.ClubDao;
import com.walfen.training.api.entities.Club;
import com.walfen.training.api.football.Player;
import com.walfen.training.api.services.ClubService;

@Service
public class ClubServiceImpl implements ClubService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClubServiceImpl.class);

	@Resource
	private ClubDao clubDao;

	@Override
	public List<Club> list() {
		LOGGER.info("list clubs");
		return clubDao.findAll();
	}

	@Override
	public Club get(Long id) {
		LOGGER.info("get club - id: {}", id);
		return clubDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Player> listPlayers(Long id) {
		LOGGER.info("get club players - id: {}", id);
		return clubDao.findPlayersById(id);
	}
}
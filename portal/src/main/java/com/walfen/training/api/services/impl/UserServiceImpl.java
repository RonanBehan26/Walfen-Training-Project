package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.UserDao;
import com.walfen.training.api.entities.User;
import com.walfen.training.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> list() {
		LOGGER.info("list users");

		return userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User get(Long id) {
		LOGGER.info("get user - id: {}", id);
		return userDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	@Override
	@Transactional
	public User create(User user) {
		LOGGER.info("create user");

		return userDao.save(user);
	}

	@Override
	@Transactional
	public User update(User user) {
		LOGGER.info("{}: update user - id: {}", user.getId());

		User storedUser = userDao.findById(user.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		storedUser.setFirstName(user.getFirstName());
		storedUser.setLastName(user.getLastName());

		return userDao.save(storedUser);
	}

}

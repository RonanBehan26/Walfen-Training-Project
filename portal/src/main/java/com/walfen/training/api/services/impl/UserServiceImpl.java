package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.walfen.training.api.daos.UserDao;
import com.walfen.training.api.entities.User;
import com.walfen.training.api.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> list() {
		LOGGER.info("list users");

		return userDao.findAll();
	}

}

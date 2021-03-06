package com.walfen.training.api.services;

import java.util.List;

import com.walfen.training.api.entities.User;

public interface UserService {

	List<User> list();

	User get(Long id);

	User create(User user);

	User update(User user);

	void delete(Long id);

}

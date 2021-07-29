package com.walfen.training.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.walfen.training.api.dtos.UserDto;
import com.walfen.training.api.entities.User;
import com.walfen.training.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> list() {
		
		List<User> users = userService.list();
		
		return users.stream().map( a -> mapper.map(a, UserDto.class)).collect(Collectors.toList());
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto get(@PathVariable Long id) {
		User user = userService.get(id);

		return mapper.map(user, UserDto.class);
	}
			

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto create(@RequestBody UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		user = userService.create(user);

		return mapper.map(user, UserDto.class);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto update(@PathVariable Long id, @RequestBody User user) {
		
		user = userService.update(user);

		return mapper.map(user, UserDto.class);
	}	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
	}


